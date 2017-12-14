package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.ProductSku;

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
     * @return
     */
    int insertProductSku(int productId, String propertykey, String propertyvaluegroup);

    /**
     * 根据标识获取指定商品属性
     * @param productId 商品ID
     * @return
     */
    ProductSku getProductSkuByProductId(int productId);
}
