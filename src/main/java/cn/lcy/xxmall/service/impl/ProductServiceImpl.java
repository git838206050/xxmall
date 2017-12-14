package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.ProductMapper;
import cn.lcy.xxmall.dao.UserMapper;
import cn.lcy.xxmall.pojo.Product;
import cn.lcy.xxmall.pojo.ProductExample;
import cn.lcy.xxmall.pojo.User;
import cn.lcy.xxmall.pojo.UserExample;
import cn.lcy.xxmall.service.ProductService;
import cn.lcy.xxmall.util.FileUtilByLcy;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author LCY
 * @Date 2017/12/4 23:07
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Product> getProducts() {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.or();
        criteria.andIdIsNotNull();
        return productMapper.selectByExample(productExample);
    }

    @Override
    public Product getProductByProductId(int productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> getProductByProductTypeId(int productTypeId) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.or();
        criteria.andProducttypeidEqualTo(productTypeId);
        return productMapper.selectByExample(productExample);
    }

    @Override
    public List<Product> getProductByProductState(byte productState) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.or();
        criteria.andProductstateEqualTo(productState);
        return productMapper.selectByExample(productExample);
    }

    @Override
    public int deleteProductByProductId(int productId) {
        int state = 0;
        Product product = productMapper.selectByPrimaryKey(productId);
        if(product != null){
            product.setProductstate((byte)-3);
            state = productMapper.updateByPrimaryKey(product);
        }
        return state;
    }

    @Override
    public int stopSellingProductByProductId(int productId) {
        int state = 0;
        Product product = productMapper.selectByPrimaryKey(productId);
        if(product != null){
            product.setProductstate((byte)-1);
            state = productMapper.updateByPrimaryKey(product);
        }
        return state;
    }

    @Override
    public int insertProductByUsername(String username, Product product) {
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.or();
        userCriteria.andUsernameEqualTo(username);
        User user = userMapper.selectByExample(userExample).get(0);
        product.setUploaduserid(user.getId());
        productMapper.insert(product);
        return product.getId();
    }

    @Override
    public int insertProduct(int shopId, Product product, String prodictSKU, String productKeyword, List<MultipartFile> productMainImages, Map<String, List<MultipartFile>> productSkuImages) {
        return 0;
    }

    @Override
    public int updateProduct(int shopId, Product product, String prodictSKU, String productKeyword, List<MultipartFile> productMainImages, Map<String, List<MultipartFile>> productSkuImages) {
        return 0;
    }

    @Override
    public boolean addProductOfValidate(String username, Product product, String prodictSKU, String productKeyword, List<MultipartFile> productMainImages, Map<String,List<MultipartFile>> productSkuImages) {
        boolean bl = false;
        try{
            String[] keywords = productKeyword.split(",");
            BigDecimal validatePrive = new BigDecimal(0);
            // 样子商品名长度
            if(product.getProductname().length() >= 1 && product.getProductname().length() <= 30){
                bl = true;
            }

            // 验证关键词
            if(bl && productKeyword.indexOf(",") != -1){
                if(keywords.length <= 10){
                    for(int i=0; i<keywords.length; i++){
                        if(keywords[i].length() > 10){
                            bl = false;
                        }
                    }
                }else{
                    bl = false;
                }
            }else if(productKeyword.length() <= 10){
                bl = true;
            }else{
                bl = false;
            }

            // 验证 原价格、折扣价格(大于0，不比较原价格与打折后的大小)
            if(product.getOriginalprive().compareTo(validatePrive)==1 && product.getDiscountprive().compareTo(validatePrive)==1){
                bl = true;
            }else{
                bl = false;
            }

            // 验证 商品描述
            if(product.getDescribing().length()>0 && product.getDescribing().length()<=255){
                bl = true;
            }else{
                bl = false;
            }

            // 验证 商品内容
            if(product.getContent().length()>0 && product.getContent().length()<=20000){
                bl = true;
            }else{
                bl = false;
            }

            // 验证 详细图片 最大为1m
            String[] fileTpe = {"jpg","png"};
            String fileCatalog = "images\\";
            for(int i=0; i<productMainImages.size(); i++){
                //MultipartFile file,Long fileSize,String[] fileType,String fileCatalog,Boolean isValidate,byte fileUrlType
                if(!FileUtilByLcy.uploadImageFile(productMainImages.get(i), 1048576L, fileTpe,fileCatalog,true,(byte)1).equals("1")){
                    bl = false;
                }
            }

            // 验证商品规划文件
            for (String str : productSkuImages.keySet()) {
                productSkuImages.get(str);
                for(int i=0; i<productSkuImages.get(str).size(); i++){
                    if(!FileUtilByLcy.uploadImageFile(productMainImages.get(i), 1048576L, fileTpe,fileCatalog,true,(byte)1).equals("1")){
                        bl = false;
                    }
                }
            }

            // 验证 商品规格长度
            if(bl){
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Object>>() {}.getType();
                ArrayList<Object> list = gson.fromJson(prodictSKU, type);
                LinkedTreeMap linkedTreeMap;
                int j = 0;
                for(int i=0; i<list.size(); i++){
                    linkedTreeMap = (LinkedTreeMap)list.get(i);
                    Set set = linkedTreeMap.keySet();
                    for (Object str : set) {
                        j++;
                        if(j>750){
                            bl = false;
                        }
                    }
                }
            }

        }catch (Exception e){
            bl = false;
        }
        return bl;
    }

    @Override
    public int validateSKU(String skuString) {

        return 0;
    }
}
