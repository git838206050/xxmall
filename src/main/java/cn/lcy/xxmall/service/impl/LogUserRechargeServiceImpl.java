package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.LogUserRechargeMapper;
import cn.lcy.xxmall.pojo.LogUserRecharge;
import cn.lcy.xxmall.pojo.LogUserRechargeExample;
import cn.lcy.xxmall.service.LogUserRechargeService;
import cn.lcy.xxmall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户充值日志
 * @Author LCY
 * @Date 2018/1/2 14:49
 */
@Service
public class LogUserRechargeServiceImpl implements LogUserRechargeService {
    @Autowired
    private LogUserRechargeMapper logUserRechargeMapper;

    @Override
    public int insertRecharge(int targetId, String rechargeNumber, String paymentVoucher, String userIp) {
        int state = 0;
        try{
            BigDecimal bigDecimal = new BigDecimal(0);
            if(new BigDecimal(rechargeNumber).compareTo(bigDecimal)==1 && targetId>0 && paymentVoucher!=null){
                LogUserRecharge logUserRecharge = new LogUserRecharge();
                logUserRecharge.setUserid(targetId);
                logUserRecharge.setRechargenumber(new BigDecimal(rechargeNumber));
                logUserRecharge.setPaymentvoucher(paymentVoucher);
                logUserRecharge.setUserip(userIp);
                logUserRecharge.setCreattime(DateUtil.getDate());
                logUserRecharge.setRechargestate((byte)0);
                state = logUserRechargeMapper.insert(logUserRecharge);
            }
        }catch (Exception e){
            state = 0;
            e.printStackTrace();
        }finally {
            return state;
        }
    }

    @Override
    public List<LogUserRecharge> getLogUserRecharges() {
        List<LogUserRecharge> logUserRechargeList = null;
        try {
            LogUserRechargeExample logUserRechargeExample = new LogUserRechargeExample();
            LogUserRechargeExample.Criteria criteria = logUserRechargeExample.or();
            criteria.andIdIsNotNull();
            logUserRechargeList = logUserRechargeMapper.selectByExample(logUserRechargeExample);
        }catch (Exception e){
            logUserRechargeList = null;
        }finally {
            return logUserRechargeList;
        }
    }

    @Override
    public List<LogUserRecharge> getLogUserRechargeOfRechargeState(int rechargeState) {
        List<LogUserRecharge> logUserRechargeList = null;
        try {
            LogUserRechargeExample logUserRechargeExample = new LogUserRechargeExample();
            LogUserRechargeExample.Criteria criteria = logUserRechargeExample.or();
            criteria.andRechargestateEqualTo((byte) rechargeState);
            logUserRechargeList = logUserRechargeMapper.selectByExample(logUserRechargeExample);
        }catch (Exception e){
            logUserRechargeList = null;
        }finally {
            return logUserRechargeList;
        }
    }

    @Override
    public int updateRecharge(LogUserRecharge logUserRecharge) {
        int state = 0;
        BigDecimal bigDecimal = new BigDecimal(0);
        try{
            LogUserRecharge oLogUserRecharge1 = logUserRechargeMapper.selectByPrimaryKey(logUserRecharge.getId());
            if(logUserRecharge.getRechargenumber()!=null && bigDecimal.compareTo(logUserRecharge.getRechargenumber()) != 1){
                oLogUserRecharge1.setRechargenumber(logUserRecharge.getRechargenumber());
                state = 1;
            }
            if(logUserRecharge.getUserip()!=null){
                oLogUserRecharge1.setUserip(logUserRecharge.getUserip());
                state = 1;
            }
            if(logUserRecharge.getRechargestate()!=null){
                oLogUserRecharge1.setRechargestate(logUserRecharge.getRechargestate());
                state = 1;
            }
            if(logUserRecharge.getPaymentvoucher()!=null){
                oLogUserRecharge1.setPaymentvoucher(logUserRecharge.getPaymentvoucher());
                state = 1;
            }

            if(state == 1){
                state = logUserRechargeMapper.updateByPrimaryKey(oLogUserRecharge1);
            }
        }catch (Exception e){
            state = 0;
        }finally {
            return state;
        }
    }
}
