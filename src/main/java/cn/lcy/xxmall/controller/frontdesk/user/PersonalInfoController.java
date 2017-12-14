package cn.lcy.xxmall.controller.frontdesk.user;

import cn.lcy.xxmall.pojo.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户个人信息
 * @Author LCY
 * @Date 2017/11/9 16:09
 */
@Controller
@RequestMapping(value = "/xxmall/frontdesk/user")
public class PersonalInfoController {
    @RequestMapping(value = "/showInfo")
    @ResponseBody
    public JsonResult showInfo(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setMessage("连接成功！");
        jsonResult.setErrorCode("200");
        return jsonResult;
    }
}
