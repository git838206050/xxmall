package cn.lcy.xxmall.controller.backstage.order;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.PdOrder;
import cn.lcy.xxmall.pojo.common.JsonLayui;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.PdOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value = "/xxmall/backstage/orderManage")
public class OrderManageController {
    @Autowired
    private PdOrderService pdOrderService;

    @RequestMapping(value = "/insertOrder")
    @ResponseBody
    public JsonResult insertOrder(@RequestParam(value = "productId" , required = false) Integer productId,
                                  @RequestParam(value = "userId" , required = false) Integer userId,
                                  @RequestParam(value = "price" , required = false) String price,
                                  @RequestParam(value = "deliverAddress" , required = false) String deliverAddress){
        JsonResult jsonResult = new JsonResult();
        try{
            if( pdOrderService.insertPdOrder(productId, userId, new BigDecimal(price) ,deliverAddress) != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else {
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }finally {
            return  jsonResult;
        }
    }

    @RequestMapping(value = "/showOrder")
    @ResponseBody
    public JsonLayui shopAdmins(@RequestParam(value = "page" , required = false) Integer page,
                                @RequestParam(value = "limit" , required = false) Integer limit){
        JsonLayui jsonLayui = new JsonLayui();// 默认显示第一页
        if(page == null || page < 1){
            page = 1;
        }
        // 默认每页显示5条
        if(limit == null || limit < 1){
            limit = 5;
        }

        // 分页
        PageHelper.startPage(page,limit);
        List<PdOrder> pdOrderList = pdOrderService.getPdOrders();
        PageInfo pageInfo = new PageInfo(pdOrderList);
        if(pdOrderList.size() > 0){
            jsonLayui.setCode(0);
            // 获取数据的总数
            jsonLayui.setCount( pageInfo.getTotal() );
            jsonLayui.setMsg(GlobalConstants.operaction_success_message);
            jsonLayui.setData(jsonLayui.toObject(pdOrderList));
        }else{
            jsonLayui.setCode(0);
            jsonLayui.setMsg(GlobalConstants.operaction_failed_message);
        }
        jsonLayui.setLimit(Long.valueOf(limit));
        jsonLayui.setPage(Long.valueOf(page));
        return jsonLayui;
    }

    /**
     * 以下是更新对应的订单对象
     */

    @RequestMapping(value = "/updataPdOrderOfExpressNo")
    @ResponseBody
    public JsonResult updataPdOrderOfExpressNo(@RequestParam(value = "expressNo" , required = true) String expressNo,
                                               @RequestParam(value = "targetId" , required = true) Integer orderId){
        JsonResult jsonResult = new JsonResult();
        try {
            int state = pdOrderService.updataPdOrderOfExpressNo(orderId, expressNo);
            if(state != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/updataPdOrderOfIsClosed")
    @ResponseBody
    public JsonResult updataPdOrderOfIsClosed(@RequestParam(value = "isClosed" , required = true) String isClosed,
                                              @RequestParam(value = "targetId" , required = true) Integer orderId){
        JsonResult jsonResult = new JsonResult();
        try {
            int state = pdOrderService.updataPdOrderOfIsClosed(orderId, isClosed);
            if(state != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/updataPdOrderOfExpressName")
    @ResponseBody
    public JsonResult updataPdOrderOfExpressName(@RequestParam(value = "expressName" , required = true) String expressName,
                                                 @RequestParam(value = "targetId" , required = true) Integer orderId){
        JsonResult jsonResult = new JsonResult();
        try {
            int state = pdOrderService.updataPdOrderOfExpressName(orderId, expressName);
            if(state != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/updataPdOrderOfDeliverAddress")
    @ResponseBody
    public JsonResult updataPdOrderOfDeliverAddress(@RequestParam(value = "deliverAddress" , required = true) String deliverAddress,
                                                    @RequestParam(value = "targetId" , required = true) Integer orderId){
        JsonResult jsonResult = new JsonResult();
        try {
            int state = pdOrderService.updataPdOrderOfDeliverAddress(orderId, deliverAddress);
            if(state != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/updataPdOrderOfOrderStatus")
    @ResponseBody
    public JsonResult updataPdOrderOfOrderStatus(@RequestParam(value = "orderStatus" , required = true) String orderStatus,
                                                 @RequestParam(value = "targetId" , required = true) Integer orderId){
        JsonResult jsonResult = new JsonResult();
        try {
            int state = pdOrderService.updataPdOrderOfOrderStatus(orderId, orderStatus);
            if(state != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

}