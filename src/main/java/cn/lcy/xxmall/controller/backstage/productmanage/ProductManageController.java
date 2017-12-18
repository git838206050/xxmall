package cn.lcy.xxmall.controller.backstage.productmanage;

import cn.lcy.xxmall.pojo.FdImage;
import cn.lcy.xxmall.pojo.Product;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.*;
import cn.lcy.xxmall.util.FileUtilByLcy;
import cn.lcy.xxmall.util.Md5Util;
import cn.lcy.xxmall.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品管理Controller
 * @Author LCY
 * @Date 2017/12/3 20:37
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/productManage")
public class ProductManageController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private FdImageService fdImageService;
    @Autowired
    private ProductFdImageService productFdImageService;
    @Autowired
    private DbaProductService dbaProductService;
    @Autowired
    private ProductSkuService productSkuService;

    @PostMapping(value = "/insertProduct")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    public JsonResult insertProduct(Product product,
                                    @RequestParam(value = "username", required = true)String username,
                                    @RequestParam(value = "keyword", required = true)String keyword,
                                    @RequestParam(value = "skuValue", required = false)String skuValueString,
                                    @RequestParam(value = "skuDetailedInof", required = false)String skuDetailedInofString,
                                    MultipartHttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        try {
            boolean state = false;
            boolean[] imageNum = {false,false,false,false};
            // 商品SKU属性图片
            // 集合的key值 对应大小的 .size()数值 也就是从0开始
            Map<String,List<MultipartFile>> productSkuImages = new HashMap<String,List<MultipartFile>>();
            for(int i=1,j=0; i<=4; i++){
                if(request.getFiles("imgProperty"+i) != null) {
                    productSkuImages.put(String.valueOf(j), request.getFiles("imgProperty" + i));
                    j++;
                }
            }

            // 获取是图片的栏目
            for(int i=0; i<productSkuImages.size(); i++){
                if(productSkuImages.get(String.valueOf(i)).size() != 0){
                    imageNum[i] = true;
                }
            }
            // 商品主图片
            List<MultipartFile> productImage = request.getFiles("productMainImages");

            // 商品类型验证
            if(productTypeService.getProductTypeById(product.getProducttypeid()) != null){
                state = true;
            }

            // 商品验证
            if (state){
                state = productService.addProductOfValidate(username,product,skuValueString,skuDetailedInofString,keyword,productImage,productSkuImages);
            }

            if(state) {
                // 将SKU图片添加到数据库中
                String[] fileType = {"jpg", "png"};
                String fileCatalog = "images\\";
                Integer productId = -1;         // 添加商品后自动递增的主键ID
                List<String> productSKUImageFileName =  new ArrayList<String>();           // 商品SKU图片相对路径名
                List<Integer> productSKUImageId = new ArrayList<Integer>(); // 商品SKU ID组
                List<Integer> productMainImageId = new ArrayList<Integer>();// 商品主图片ID组
                List<String> productMainImageFileName =  new ArrayList<String>();           // 商品主图片相对路径名


                for (int i = 0; i < productSkuImages.size(); i++) {
                    int ii = productSkuImages.get(String.valueOf(i)).size();
                    for (int j = 0; j < ii; j++) {
                        MultipartFile file = productSkuImages.get(String.valueOf(i)).get(j);
                        String imageMd5 = Md5Util.md5(StrUtil.newString(file.getBytes()));

                        FdImage fdImage = fdImageService.getFdImageByImageEncrypt(imageMd5);
                        if(fdImage == null){
                            // 上传图片到服务器 并保存 商品SKU图片相对路径在集合里
                            productSKUImageFileName.add( FileUtilByLcy.uploadImageFile(productSkuImages.get(String.valueOf(i)).get(j), 1048576L, fileType, fileCatalog, false, (byte) 1) );

                        }else{
                            productSKUImageFileName.add(fdImage.getImageurl());
                        }
                        // 把图片添加到前端图片数据库中 并保存 商品SKU图片ID在集合里
                        productSKUImageId.add( fdImageService.insertImage(productSkuImages.get(String.valueOf(i)).get(j)) );

                    }
                }

                // 将商品主图片组添加到数据库中
                for (int i = 0; i < productImage.size(); i++) {
                    MultipartFile file = productImage.get(i);
                    String imageMd5 = Md5Util.md5(StrUtil.newString(file.getBytes()));

                    FdImage fdImage = fdImageService.getFdImageByImageEncrypt(imageMd5);
                    if(fdImage == null){
                        // 上传图片到服务器 并保存商品主图片相对路径在集合里
                        productMainImageFileName.add( FileUtilByLcy.uploadImageFile(productImage.get(i), 1048576L, fileType, fileCatalog, false, (byte) 1) );
                    }else{
                        productMainImageFileName.add(fdImage.getImageurl());
                    }
                    // 把图片添加到前端数据 并保存 商品主图片ID在集合里
                    productMainImageId.add(fdImageService.insertImage(productImage.get(i)));
                }

                // 添加商品到数据库中 并获取自动递增的商品主键ID,
                productId = productService.insertProductByUsername(username,product, productMainImageFileName.size()>0 ? productMainImageFileName.get(0):"");

                // 添加商品与主图片的多对多表
                for (int i = 0; i < productMainImageId.size(); i++) {
                    productFdImageService.insertProductFdImage(productId, productMainImageId.get(i), (byte) 1, 50);
                }

                // 添加关键词
                dbaProductService.insertDbaProducts(keyword, productId);
                // 添加商品规格
                productSkuService.insertProductSku(productId, skuValueString, skuDetailedInofString, imageNum, productSKUImageFileName);

                jsonResult.setErrorCode("200");
            }
        }catch (Exception e){
            jsonResult.setErrorCode("400");
            e.printStackTrace();
        }
        System.out.println("--");
         return jsonResult;
    }
}
