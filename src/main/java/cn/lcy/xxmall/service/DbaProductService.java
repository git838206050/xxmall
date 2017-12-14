package cn.lcy.xxmall.service;

import cn.lcy.xxmall.exception.MyDaoException;
import cn.lcy.xxmall.pojo.DbaProduct;

import java.util.List;

/**
 * 商品关键字搜索逻辑
 * @Author LCY
 * @Date 2017/12/6 14:40
 */
public interface DbaProductService {
    /**
     * 根据标识添加商品搜索索引
     * @param keyword 关键词
     * @param productId 商品ID
     * @return
     */
    int insertDbaProduct(String keyword, int productId);

    /**
     * 根据标识批量添加商品搜索索引
     * @param keywords 关键词组
     * @param productId 商品ID
     * @return
     */
    int insertDbaProducts(String[] keywords, int productId) throws MyDaoException;

    /**
     * 根据标识批量添加商品搜索索引
     * @param keywords 关键词组,以，隔开
     * @param productId 商品ID
     * @return
     */
    int insertDbaProducts(String keywords, int productId) throws Exception;

    /**
     * 根据标识获取搜索索引
     * @param keyword 关键词
     * @return
     */
    List<DbaProduct> getDbaProduct(String keyword);

    /**
     * 根据标识获取搜索索引
     * @param keywords 关键词组
     * @return
     */
    List<DbaProduct> getDbaProducts(String[] keywords);
}
