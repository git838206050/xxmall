package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.LogUserRecharge;

import java.util.List;

/**
 * 充值业务日志
 * @Author LCY
 * @Date 2018/1/2 14:36
 */
public interface LogUserRechargeService {
    /**
     * 用户充值业务
     * @param targetId 对象id，用户id
     * @param rechargeNumber 充值的数量
     * @param paymentVoucher 支付凭证
     * @param userIp 用户充值时所用的ip
     * @return
     */
    int insertRecharge(int targetId, String rechargeNumber, String paymentVoucher, String userIp);

    /**
     * 获取所有用户充值日志
     * @return
     */
    List<LogUserRecharge> getLogUserRecharges();

    /**
     * 根据标识获取指定充值日志
     * @param rechargeState 充值状态(0:未审核；1:充值成功 2:充值失败)
     * @return
     */
    List<LogUserRecharge> getLogUserRechargeOfRechargeState(int rechargeState);

    /**
     * 根据标识更新指定对象
     * @param logUserRecharge 充值日志对象
     * @return
     */
    int updateRecharge(LogUserRecharge logUserRecharge);
}
