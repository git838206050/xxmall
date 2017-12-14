package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.ProductTypeProperty;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/27 23:20
 */
public interface ProductTypePropertyService {
    /**
     * 根据标识获取商品属性值
     * @param productTypeId
     * @return
     */
    List<ProductTypeProperty> getProductTypePropertysByProductTypeId(int productTypeId);
}
