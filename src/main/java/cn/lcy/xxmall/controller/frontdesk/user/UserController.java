package cn.lcy.xxmall.controller.frontdesk.user;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.User;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.UserService;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.JedisUtil;
import cn.lcy.xxmall.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制器
 * @Author LCY
 * @Date 2017/11/8 9:24
 */
@Controller
@RequestMapping(value = "/xxmall/frontdesk")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public JsonResult login(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password){
        JsonResult jsonResult = new JsonResult();
        User user = userService.login(username,password);
        if(user==null){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }else{
            // 登录成功
            Map<String, String> userMap = new HashMap<String, String>();
            Date date = DateUtil.getDate();
            Long endTime = date.getTime() + Long.valueOf(2 * 60 * 60 * 1000);    // 结束时间，创建时间往后推两个小时。以getTime的形式
            userMap.put("uToken", JwtUtil.createJWT(user.getId(), DateUtil.changeTimeAxis(date, endTime),date,(byte)1));
            userMap.put("endTime",String.valueOf(endTime));

            // 把token保存到redis缓存内，key规范为"user_"加管理员id
            Jedis jedis = JedisUtil.getJedis();
            jedis.hmset("user_"+user.getId(),userMap);
            jedis.expire("user_"+user.getId(),60*60*2);    // 设置有效时间，时间到了会自动删除该值。单位为：秒（60*60*2表示的有效时间是2小时）

            userMap.put("userId",String.valueOf(user.getId()));
            userMap.put("nickname",user.getNickname());
            userMap.put("level",String.valueOf(user.getLevel()));
            userMap.put("question",user.getQuestion());
            userMap.put("headerUrl",user.getHeaderurl());

            Map<Object, Object> userMap2 = new HashMap<Object, Object>();
            userMap2.put("user",userMap);

            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
            jsonResult.setItem(userMap2);
        }
        return jsonResult;
    }
}
