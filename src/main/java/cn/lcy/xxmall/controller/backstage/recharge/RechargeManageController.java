package cn.lcy.xxmall.controller.backstage.recharge;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.LogUserRecharge;
import cn.lcy.xxmall.pojo.common.JsonLayui;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.LogUserRechargeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用户支付日志
 * @Author LCY
 * @Date 2018/1/2 15:18
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/rechargeManage")
public class RechargeManageController {
    @Autowired
    private LogUserRechargeService logUserRechargeService;
    @Autowired
    private  HttpServletRequest request;

    /**
     * 执行用户充值请求
     * @param targetId 对象id（用户id）
     * @param rechargeNumber 充值金额
     * @param paymentVoucher 充值凭证
     * @return
     */
    @RequestMapping(value = "/insertRecharge")
    @ResponseBody
    public JsonResult insertRecharge(@RequestParam(value = "targetId", required = true)Integer targetId,
                                     @RequestParam(value = "rechargeNumber", required = true)String rechargeNumber,
                                     @RequestParam(value = "paymentVoucher", required = true)String paymentVoucher){
        JsonResult jsonResult = new JsonResult();
        try{
            // 获取用户ip
            String userIp = request.getRemoteAddr();
            int state = logUserRechargeService.insertRecharge(targetId, rechargeNumber, paymentVoucher, userIp);
            if(state != 0){
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            }else{
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            }
        }catch (Exception e){
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
        }finally {
            return jsonResult;
        }
    }

    /**
     * 获取所有充值日志
     * @param state 状态码
     * @return
     */
    @RequestMapping(value = "/showRecharges")
    @ResponseBody
    public JsonLayui showRecharges(@RequestParam(value = "state", required = false)Integer state,
                                  @RequestParam(value = "page" , required = false) Integer page,
                                  @RequestParam(value = "limit" , required = false) Integer limit){
        JsonLayui jsonLayui = new JsonLayui();
        try{
            // 默认显示第一页
            if(page == null || page < 1){
                page = 1;
            }
            // 默认每页显示5条
            if(limit == null || limit < 1){
                limit = 5;
            }
            // 分页
            PageHelper.startPage(page,limit);
            List<LogUserRecharge> logUserRecharge;
            if(state!=null){
                logUserRecharge = logUserRechargeService.getLogUserRechargeOfRechargeState(state);
            }else{
                logUserRecharge = logUserRechargeService.getLogUserRecharges();
            }
            PageInfo pageInfo = new PageInfo(logUserRecharge);
            if(logUserRecharge.size() > 0){
                jsonLayui.setCode(0);
                // 获取数据的总数
                jsonLayui.setCount( pageInfo.getTotal() );
                jsonLayui.setMsg(GlobalConstants.operaction_success_message);
                jsonLayui.setData(jsonLayui.toObject(logUserRecharge));
            }else{
                jsonLayui.setCode(0);
                jsonLayui.setMsg(GlobalConstants.operaction_failed_message);
            }
            jsonLayui.setLimit(Long.valueOf(limit));
            jsonLayui.setPage(Long.valueOf(page));

        }catch (Exception e){
            jsonLayui.setCode(0);
            jsonLayui.setMsg(GlobalConstants.operaction_failed_message);
        }finally {
            return jsonLayui;
        }
    }

    /**
     * 获取所有充值日志
     * @param state 状态码
     * @return
     */
    @RequestMapping(value = "/updateRecharges")
    @ResponseBody
    public JsonResult updateRecharges(@RequestParam(value = "targetId", required = false)Integer targetId,
                                      @RequestParam(value = "state", required = false)Integer state,
                                      @RequestParam(value = "rechargenumber", required = false)String rechargenumber,
                                      @RequestParam(value = "paymentvoucher", required = false)String paymentvoucher){
        JsonResult jsonResult = new JsonResult();
        LogUserRecharge logUserRecharge = new LogUserRecharge();
        try {
            logUserRecharge.setId(targetId);
            logUserRecharge.setPaymentvoucher(paymentvoucher);
            if(state!=null){
                logUserRecharge.setRechargestate((byte)state.intValue());
            }
            if(rechargenumber!=null && !"".equals(rechargenumber)){
                logUserRecharge.setRechargenumber(new BigDecimal(rechargenumber));
            }
            int returnState = logUserRechargeService.updateRecharge(logUserRecharge);
            if (returnState != 1) {
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            } else {
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            }
        }catch (Exception e){
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
        }finally {
            return jsonResult;
        }
    }

}
