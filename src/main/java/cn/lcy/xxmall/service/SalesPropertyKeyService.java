package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.SalesPropertyKey;

import java.util.List;

/**
 * 商品属性
 * @Author LCY
 * @Date 2017/11/27 23:43
 */
public interface SalesPropertyKeyService {
    /**
     * 获取所有商品属性
     * @return
     */
    List<SalesPropertyKey> getSalesPropertyKeys();

    /**
     * 根据标识获取指定商品属性
     * @param salesPropertyKeyId 商品属性ID
     * @return
     */
    SalesPropertyKey getSalesPropertyKeyBySalesPropertyKeyId(int salesPropertyKeyId);
}
