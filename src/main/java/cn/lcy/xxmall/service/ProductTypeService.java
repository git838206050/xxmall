package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.ProductType;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/27 23:02
 */
public interface ProductTypeService {
    /**
     * 获取所有商品分类
     * @return
     */
    List<ProductType> getProductTypes();

    /**
     * 根据标识获取指定商品分类
     * @param id 商品分类ID
     * @return
     */
    ProductType getProductTypeById(int id);

    /**
     * 根据标识获取指定商品分类
     * @param orderNum 商品排序
     * @return
     */
    List<ProductType> getProductTypeByOrderNum(int orderNum);

    /**
     * 根据标识获取指定商品分类
     * @param orderNum1 商品排序开始
     * @param orderNum2 商品排序结束
     * @return
     */
    List<ProductType> getProductTypeByOrderNum(int orderNum1, int orderNum2);

    /**
     * 根据标识获取商品分类
     * @param parent 父节点
     * @return
     */
    List<ProductType> getProductTypesByParent(String parent);
}
