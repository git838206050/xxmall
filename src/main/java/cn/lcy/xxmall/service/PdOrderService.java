package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.PdOrder;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品订单业务类
 * @Author LCY
 * @Date 2017/12/22 21:18
 */
public interface PdOrderService {
    /**
     * 添加订单请求
     * @param productId 商品id
     * @param userId 用户id
     * @param price 下单价格
     * @param deliverAddress 收货地址
     * @return 0表示添加失败
     */
    int insertPdOrder(int productId, int userId, BigDecimal price, String deliverAddress );

    /**
     * 获取所有订单
     * @return
     */
    List<PdOrder> getPdOrders();

    /**
     * 根据标识获取订单集合
     * @param userId 用户id
     * @return
     */
    List<PdOrder> getPdOrders(int userId);

    /**
     * 根据标识获取订单集合
     * @param createTime 下单时间
     * @return
     */
    List<PdOrder> getPdOrdersOfCreateTime(String createTime);

    /**
     * 根据标识获取订单集合
     * @param expressNo 快递号
     * @return
     */
    List<PdOrder> getPdOrdersOfExpressNo(String expressNo);

    /**
     * 传入订单对象更新订单
     * @param pdOrder 订单对象
     * @return 0表示更新失败
     */
    int updataPdOrder(PdOrder pdOrder);

    /**
     * 根据标识编辑订单
     * @param expressNo 快递号
     * @return 0表示更新失败
     */
    int updataPdOrderOfExpressNo(int orderId, String expressNo);

    /**
     * 根据标识编辑订单
     * @param isClosed 是否已完结订单
     * @return 0表示更新失败
     */
    int updataPdOrderOfIsClosed(int orderId, String isClosed);

    /**
     * 根据标识编辑订单
     * @param expressName 快递号
     * @return 0表示更新失败
     */
    int updataPdOrderOfExpressName(int orderId, String expressName);

    /**
     * 根据标识编辑订单
     * @param deliverAddress 收货地址
     * @return 0表示更新失败
     */
    int updataPdOrderOfDeliverAddress(int orderId, String deliverAddress);

    /**
     * 根据标识编辑订单
     * @param orderStatus 订单状态
     * @return 0表示更新失败
     */
    int updataPdOrderOfOrderStatus(int orderId, String orderStatus);

}
