package cn.lcy.xxmall.controller.backstage.productmanage;

import cn.lcy.xxmall.exception.MyDaoException;
import cn.lcy.xxmall.pojo.Product;
import cn.lcy.xxmall.pojo.Shop;
import cn.lcy.xxmall.pojo.User;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.*;
import cn.lcy.xxmall.util.FileUtilByLcy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.lang.reflect.Type;
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
    private ShopService shopService;

    @Autowired
    private UserService userService;

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
        jsonResult.setErrorCode("200");
        try {
            boolean state = false;
            // 商品SKU属性图片
            // 集合的key值 对应大小的 .size()数值 也就是从0开始
            Map<String,List<MultipartFile>> productSkuImages = new HashMap<String,List<MultipartFile>>();
            for(int i=1,j=0; i<=4; i++){
                if(request.getFiles("imgProperty"+i) != null) {
                    productSkuImages.put(String.valueOf(j), request.getFiles("imgProperty" + i));
                    j++;
                }
            }

            // 商品主图片
            List<MultipartFile> productImage = request.getFiles("productImage");

            // 商品类型验证
            if(productTypeService.getProductTypeById(product.getProducttypeid()) != null){
                state = true;
            }

            // 商品验证
            if (state){
                state = productService.addProductOfValidate(username,product,skuValueString,keyword,productImage,productSkuImages);
                state = false;
                System.out.println(skuDetailedInofString);
            }

            if(state) {
                // 将SKU图片添加到数据库中
                String[] fileType = {"jpg", "png"};
                String fileCatalog = "fdFileUpload\\images";
                int productId = -1;         // 添加商品后自动递增的主键ID
                List<String> productSKUImageFileName =  new ArrayList<String>();           // 商品SKU图片相对路径名
                List<Integer> productSKUImageId = new ArrayList<Integer>(); // 商品SKU ID组
                List<Integer> productMainImageId = new ArrayList<Integer>();// 商品主图片ID组
                List<String> productMainImageFileName =  new ArrayList<String>();           // 商品主图片相对路径名

                for (int i = 0; i < productSkuImages.size(); i++) {
                    for (int j = 0; j < productSkuImages.get(i).size(); j++) {
                        // 上传图片到服务器 并保存 商品SKU图片相对路径在集合里
                        productSKUImageFileName.add( FileUtilByLcy.uploadImageFile(productSkuImages.get(i).get(j), 1048576L, fileType, fileCatalog, false, (byte) 1) );
                        // 把图片添加到前端图片数据库中 并保存 商品SKU图片ID在集合里
                        productSKUImageId.add( fdImageService.insertImage(productSkuImages.get(i).get(j)) );
                    }
                }

                // 将商品主图片组添加到数据库中
                for (int i = 0; i < productImage.size(); i++) {
                    // 上传图片到服务器 并保存商品主图片相对路径在集合里
                    productMainImageFileName.add( FileUtilByLcy.uploadImageFile(productImage.get(i), 1048576L, fileType, fileCatalog, false, (byte) 1) );
                    // 把图片添加到前端数据 并保存 商品主图片ID在集合里
                    productMainImageId.add(fdImageService.insertImage(productImage.get(i)));
                }

                // 添加商品到数据库中 并获取自动递增的商品主键ID
                productId = productService.insertProductByUsername(username,product);

                // 添加商品与主图片的多对多表
                for (int i = 0; i < productMainImageId.size(); i++) {
                    productFdImageService.insertProductFdImage(productId, productMainImageId.get(i), (byte) 1, i);
                }

                // 添加关键词
                dbaProductService.insertDbaProducts(keyword, productId);

                // 添加商品规格

            }


//            dbaProductService.insertDbaProducts(keyword, 1);
        }catch (Exception e){
            System.out.println("1112");
            jsonResult.setErrorCode("400");
        }
        System.out.println("55");
         return jsonResult;
    }
}
