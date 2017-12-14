package cn.lcy.xxmall.controller.backstage.admin;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.Admin;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.AdminService;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.FileUtilByLcy;
import cn.lcy.xxmall.util.JedisUtil;
import cn.lcy.xxmall.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/xxmall/backstage/")
public class AdminController {
    public AdminController(){}
    @Autowired
    private AdminService adminService;

    private static GlobalConstants globalConstants = new GlobalConstants();

    /**
     * 执行登录请求
     * @param adminName 用于接收前台发送过来的账号
     * @param password 用于接收前台发送过来的密码
     * @param httpServletResponse
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public JsonResult adminLogin(@RequestParam(value = "login", required = false) String adminName,
                                 @RequestParam(value = "pwd", required = false) String password,
                                 HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest){
        JsonResult jsonResult = new JsonResult();   // 发送到前端的json数据
        // 登录验证
        Admin admin =  adminService.login(adminName,password);
        Integer loginState = null;// 登录状态。 默认为失败（null：失败，1：成功，2：禁止登录）
        if(admin != null){
            if(admin.getProhibitlogintime() == null && admin.getRecovery() == null){
                loginState = 1;
            }else if(admin.getRecovery() != null) {
                // 已被回收
                loginState = 2;
            }else if(admin.getProhibitlogintime() != null){
                // 判断禁止登陆时间
                loginState = DateUtil.compareTimeStamp(new Date(), admin.getProhibitlogintime());
            }
        }

        // 根据登录状态，向前端输出指定信息，信息来源于数据库（启动tomcat后自动执行InitAction初始化变量）
        if(loginState == null){
            // 登录失败
            jsonResult.setErrorCode(globalConstants.admin_login_failed_code);
            jsonResult.setMessage(globalConstants.admin_login_failed_message);
        }else if(loginState == 1){
            // 登录成功
            Map<String, String> adminMap = new HashMap<String,String>();    // 用于存储在redis的管理员信息
            Date date = DateUtil.getDate();
            String apiToken;
            Long endTime = date.getTime() + Long.valueOf(2 * 60 * 60 * 1000);    // 结束时间，创建时间往后推两个小时。以getTime的形式
            // 创建jwt
            apiToken = JwtUtil.createJWT(admin.getId(), DateUtil.changeTimeAxis(date, endTime), date,(byte)0);
            adminMap.put("token",apiToken);
            adminMap.put("endTime",String.valueOf(endTime));
            // 把token保存到redis缓存内，key规范为"admin_"加管理员id
            Jedis jedis = JedisUtil.getJedis();
            jedis.hmset("admin_"+admin.getId(),adminMap);
            jedis.expire("admin_"+admin.getId(),60*60*2);    // 设置有效时间，时间到了会自动删除该值。单位为：秒（这里设置的有效时间是2小时）

            Map<Object, Object> adminMap2 = new HashMap<Object,Object>();    // 保存着输出于前端的admin信息
            adminMap2.put("adminId",admin.getId());
            adminMap2.put("adminName",admin.getAdminname());
            adminMap2.put("token",apiToken);
            adminMap2.put("nickname",admin.getNickname());
            adminMap2.put("headerUrl",admin.getHeaderurl());

            Map<Object, Object> adminMap3 = new HashMap<Object,Object>();    // 用于存储在客户浏览器内的管理员信息
            adminMap3.put("admin",adminMap2);

            jsonResult.setErrorCode(globalConstants.admin_login_success_code);
            jsonResult.setMessage(globalConstants.admin_login_success_message);
            jsonResult.setItem(adminMap3);
        }else if(loginState == 2){
            // 登录成功，但禁止登录
            jsonResult.setErrorCode(globalConstants.admin_login_prohibit_code);
            jsonResult.setMessage(globalConstants.admin_login_prohibit_message);
        }

        return jsonResult;
    }

    /**
     * 执行注册请求
     * @param admin
     * @param httpServletResponse
     * @param httpServletRequest
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public JsonResult adminRegister(Admin admin,
                                    @RequestParam(value="header",required=false) MultipartFile file,
                                    @RequestParam(value="adminId",required=true) Integer adminId,
                                    HttpServletResponse httpServletResponse,
                                    HttpServletRequest httpServletRequest){
        JsonResult jsonResult = new JsonResult();   // 发送到前端的json数据
        int registerState = adminService.insert(adminId,admin,file);
        if (registerState == 1) {
            // 添加成功
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }else if(registerState == 0){
            // 添加失败
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }else if(registerState == 2){
            // 没有操作权限
            jsonResult.setErrorCode(GlobalConstants.operation_not_authority_code);
            jsonResult.setMessage(GlobalConstants.operation_not_authority_message);

        }
        return jsonResult;
    }

    /**
     * 执行注销请求
     * @param adminId
     * @param token
     * @param httpServletResponse
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public JsonResult adminLogout(@RequestParam(value = "id") Integer adminId,
                                  @RequestParam(value = "token") String token,
                                  HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest){
        JsonResult jsonResult = new JsonResult();   // 发送到前端的json数据
        Jedis jedis = JedisUtil.getJedis();
        List<String> adminInfo = jedis.hmget("admin_"+adminId,"token","endTime");
        if(adminInfo.size()!=0 && adminInfo.get(0)!=null && adminInfo.get(0).equals(token)){
            jedis.del("admin_"+adminId);
            jsonResult.setErrorCode("200");
            jsonResult.setMessage("注销成功！");
        }else{
            jsonResult.setErrorCode("500");
            jsonResult.setMessage("注销失败！");
        }
        return jsonResult;
    }

    /**
     * 测试使用
     * @param jsonResult
     * @return
     */
    @RequestMapping(value = "/returnError")
    @ResponseBody
    public JsonResult returnError(JsonResult jsonResult){
        jsonResult = new JsonResult();   // 发送到前端的json数据
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("date",DateUtil.getDate());
        jsonResult.setMessage("连接成功！");
        jsonResult.setErrorCode("200");
        jsonResult.setItem(map);
        return jsonResult;
    }
}
