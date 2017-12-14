package cn.lcy.xxmall.controller.backstage.shopmanage;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.exception.MyAdminPurviewException;
import cn.lcy.xxmall.exception.MyFormPropertyException;
import cn.lcy.xxmall.pojo.Shop;
import cn.lcy.xxmall.pojo.common.JsonLayui;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 店铺管理
 * @Author LCY
 * @Date 2017/11/17 12:33
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/shopManage")
public class ShopManageController {
    @Autowired
    private ShopService shopService;

    /**
     * 执行添加商铺请求
     * @param username 该店铺的用户名
     * @param adminId 执行该请求的管理员id
     * @param shopName 商铺名
     * @param address 商铺发货地址
     * @param decorateContent 商铺装修
     * @return
     */
    @PostMapping(value = "/insertShop")
    @ResponseBody
    public JsonResult insertShop(@RequestParam(value="username")String username,
                                 @RequestParam(value="adminId")Integer adminId,
                                 @RequestParam(value="shopName")String shopName,
                                 @RequestParam(value="address")String address,
                                 @RequestParam(value="decorateContent")String decorateContent){
        JsonResult jsonResult = new JsonResult();
        int state = 0;
        try {
            state = shopService.insertShop(username, adminId, shopName, address, decorateContent);
            if(state == 1){
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            }else{
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            }
        } catch (MyFormPropertyException e) {
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
        } catch (MyAdminPurviewException e){
            jsonResult.setMessage(GlobalConstants.operation_not_authority_message);
            jsonResult.setErrorCode(GlobalConstants.operation_not_authority_code);
        } catch (Exception e){
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            e.printStackTrace();
        }finally {
            return jsonResult;
        }
    }

    @PostMapping(value = "/showShop")
    @ResponseBody
    public JsonLayui showShop(@RequestParam(value = "page" , required = false) Integer page,
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
        List<Shop> shopList = shopService.getShopsOfState1();
        PageInfo pageInfo = new PageInfo(shopList);

        jsonLayui.setCount( pageInfo.getTotal() );
        jsonLayui.setData(jsonLayui.toObject(shopList));
        jsonLayui.setCode(0);
        jsonLayui.setLimit(Long.valueOf(limit));
        jsonLayui.setPage(Long.valueOf(page));
        return jsonLayui;
    }
}
