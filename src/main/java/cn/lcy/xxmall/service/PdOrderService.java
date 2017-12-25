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
     * 根据表示获取订单集合
     * @param userId 用户id
     * @return
     */
    List<PdOrder> getPdOrders(int userId);

    /**
     * 根据表示获取订单集合
     * @param createTime 下单时间
     * @return
     */
    List<PdOrder> getPdOrdersOfCreateTime(String createTime);

    /**
     * 根据表示获取订单集合
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

}
