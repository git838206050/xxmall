package cn.lcy.xxmall.controller.backstage.order;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.PdOrder;
import cn.lcy.xxmall.pojo.common.JsonLayui;
import cn.lcy.xxmall.service.PdOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 订单管理Controller
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/orderManage")
public class OrderManageController {
    @Autowired
    private PdOrderService pdOrderService;

    @RequestMapping(value = "/showOrder")
    public JsonLayui shopAdmins(@RequestParam(value = "page" , required = false) Integer page,
                                @RequestParam(value = "limit" , required = false) Integer limit){
        JsonLayui jsonLayui = new JsonLayui();
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
        return  jsonLayui;
    }

}
