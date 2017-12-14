package cn.lcy.xxmall.controller.backstage.shopmanage;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.Shop;
import cn.lcy.xxmall.pojo.User;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.ShopService;
import cn.lcy.xxmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 店铺查询
 * @Author LCY
 * @Date 2017/11/20 16:38
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/shopManage/shopQuery")
public class ShopQueryController {
    @Autowired
    private UserService userService;

    @Autowired
    private ShopService shopService;

    protected static User user;
    protected  static Shop shop;

    @PostMapping(value = "/queryUsername")
    @ResponseBody
    public JsonResult queryAdminByAdminName(@RequestParam(value = "username", required = true)String username){
        JsonResult jsonResult = new JsonResult();
        user = null;
        shop = null;
        user = userService.getUserByUsername(username);
        // 用户名存在
        if(user == null){
            jsonResult.setErrorCode(GlobalConstants.validate_shop_username_not_existent_code);
            jsonResult.setMessage(GlobalConstants.validate_shop_username_not_existent_message);
        }else{
            shop = shopService.getShopByUserId(user.getId());
            // 用户已创建店铺
            if(shop != null){
                jsonResult.setErrorCode(GlobalConstants.validate_shop_userid_existent_code);
                jsonResult.setMessage(GlobalConstants.validate_shop_userid_existent_message);
            }else{
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }
        }
        return jsonResult;
    }

    @PostMapping(value = "/queryShopName")
    @ResponseBody
    public JsonResult queryAdminByShopName(@RequestParam(value = "shopName", required = true)String shopName){
        JsonResult jsonResult = new JsonResult();
        shop = null;
        shop = shopService.getShopByShopName(shopName);
        if(shop != null){
            jsonResult.setErrorCode(GlobalConstants.validate_shop_userid_existent_code);
            jsonResult.setMessage(GlobalConstants.validate_shop_userid_existent_message);
        }else{
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }
        return jsonResult;
    }
}
