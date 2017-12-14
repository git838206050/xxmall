package cn.lcy.xxmall.controller.backstage.main;

import cn.lcy.xxmall.pojo.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LCY
 * @Date 2017/10/28 9:01
 */
@Controller
@RequestMapping(value = "/xxmall/backstage")
public class IndexController {
    /**
     * 执行跳转到首页请求
     * @return
     */
    @PostMapping(value = "/index")
    @ResponseBody
    public JsonResult index(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setMessage("欢迎来到xx商城后台管理页面");
        jsonResult.setErrorCode("200");
        return jsonResult;
    }

}
