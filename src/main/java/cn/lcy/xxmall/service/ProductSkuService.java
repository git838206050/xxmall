package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.ProductSku;

import java.util.List;

/**
 * 商品SKU业务
 * @Author LCY
 * @Date 2017/12/12 15:20
 */
public interface ProductSkuService {
    /**
     * 根据标识添加指定商品SKU属性
     * @param productId 商品ID
     * @param propertykey 属性key值(json 转String类型)
     * @param propertyvaluegroup 属性value值匹配（匹配的库存、价格json 转String类型）
     * @param imageNum 第n组为图片
     * @param productSKUImageFileName 图片相对路径组
     * @return
     */
    int insertProductSku(int productId, String propertykey, String propertyvaluegroup, boolean[] imageNum,  List<String> productSKUImageFileName);

    /**
     * 根据标识获取指定商品属性
     * @param productId 商品ID
     * @return
     */
    ProductSku getProductSkuByProductId(int productId);
}
