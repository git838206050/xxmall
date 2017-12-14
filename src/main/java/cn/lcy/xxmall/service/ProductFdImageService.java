package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.ProductFdImage;

import java.util.List;

/**
 * 商品与图片对多对类
 * @Author LCY
 * @Date 2017/12/10 20:59
 */
public interface ProductFdImageService {
    /**
     * 根据标识添加指定对象
     * @param productId 商品ID
     * @param imageId 图片ID
     * @param imageType 图片类型（1：商品主图片（非封面，封面排序值为1）； 2：商品规格图片；）
     * @param orderNum 排序(从0开始，越小值越排前面)
     * @return
     */
    int insertProductFdImage(int productId, int imageId, Byte imageType, int orderNum);

    /**
     * 根据标识批量添加对象
     * 添加的参数为：(int productId, int imageId, Byte imageType, int orderNum)
     *  productId 商品ID
     *  imageId 图片ID
     *  imageType 图片类型（1：商品主图片； 2：商品规格图片；）
     *  orderNum 排序(从1开始，越小值越排前面)
     * @param productFdImageList
     * @return
     */
    int insertProductFdImages(List<ProductFdImage> productFdImageList);

    /**
     * 根据标识获取所有对象,以orderNum 为排序， 最小的排在最前面
     * @param productId 商品ID
     * @return
     */
    List<ProductFdImage> getProductFdImagesByProductId(int productId);


}
