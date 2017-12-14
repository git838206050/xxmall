package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 商品业务类
 * @Author LCY
 * @Date 2017/12/3 20:40
 */
@Service
public interface ProductService {
    /**
     * 获取所有商品
     * @return
     */
    List<Product> getProducts();

    /**
     * 根据标识获取指定商品
     * @param productId 商品ID
     * @return
     */
    Product getProductByProductId(int productId);

    /**
     * 根据标识获取指定商品
     * @param productTypeId 商品类型ID
     * @return
     */
    List<Product> getProductByProductTypeId(int productTypeId);

    /**
     * 根据标识获取指定商品
     * @param productState 商品审核状态
     * @return
     */
    List<Product> getProductByProductState(byte productState);

    /**
     * 根据标识添加商品
     * @param username 用户名
     * @param product 商品对象
     * @return 添加商品是自动递增的主键值
     */
    int insertProductByUsername(String username, Product product);


    /**
     * 执行添加商品
     * @param shopId 店铺ID
     * @param product 商品对象
     * @param prodictSKU 商品SKU
     * @param productKeyword 商品关键字
     * @param productMainImages 商品主要显示的图片，第一张为主要封面
     * @param productSkuImages 商品SKU图片
     * @return
     */
    int insertProduct(int shopId, Product product, String prodictSKU, String productKeyword, List<MultipartFile> productMainImages, Map<String,List<MultipartFile>> productSkuImages);

    /**
     * 根据标识删除指定商品
     * @param productId 商品ID
     * @return
     */
    int deleteProductByProductId(int productId);

    /**
     * 根据标识下架指定商品
     * @param productId 商品ID
     * @return
     */
    int stopSellingProductByProductId(int productId);

    /**
     * 修改商品
     * @param shopId
     * @param product
     * @param prodictSKU
     * @param productKeyword
     * @param productMainImages
     * @param productSkuImages
     * @return
     */
    int updateProduct(int shopId, Product product, String prodictSKU, String productKeyword, List<MultipartFile> productMainImages, Map<String,List<MultipartFile>> productSkuImages);

    /**
     * 验证添加商品
     * @param username 用户名
     * @param product 商品对象
     * @param prodictSKU 商品SKU
     * @param productKeyword 商品关键字
     * @param productMainImages 商品主要显示的图片，第一张为主要封面
     * @param productSkuImages 商品SKU图片
     * @return
     */
    boolean addProductOfValidate(String username, Product product, String prodictSKU, String productKeyword, List<MultipartFile> productMainImages, Map<String,List<MultipartFile>> productSkuImages);

    int validateSKU(String skuString);
}
