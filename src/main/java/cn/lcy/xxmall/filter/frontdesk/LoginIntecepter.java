package cn.lcy.xxmall.filter.frontdesk;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.JedisUtil;
import cn.lcy.xxmall.util.StrUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 登录拦截器
 * @Author LCY
 * @Date 2017/10/26 19:33
 *
 （1）preHandle: 在执行controller处理之前执行，返回值为boolean ,返回值为true时接着执行postHandle和afterCompletion，如果我们返回false则中断执行
 （2）postHandle:在执行controller的处理后，在ModelAndView处理前执行
 （3）afterCompletion ：在DispatchServlet执行完ModelAndView之后执行
 */
public class LoginIntecepter implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Boolean result = false; // 拦截状态，false表示拦截，true表示通过
        String uToken = httpServletRequest.getParameter("uToken");        // 获取前端发送过来的token认证
        String userId = httpServletRequest.getParameter("userId");    // 获取前端发送过来的管理员id
        Jedis jedis = JedisUtil.getJedis();
        List<String> userInfo = jedis.hmget("user_"+userId,"uToken","endTime");   // get(0)返回token， get(1)返回时间  Long.valueOf(adminInfo.get(1)

        if( userInfo.size()>0 && userInfo.get(0)!=null && userInfo.get(0).equals(uToken) ){
            Integer dateState = DateUtil.compareTimeStamp( DateUtil.getDate() , DateUtil.getDate( Long.valueOf(userInfo.get(1) ))); // 判断token有效时间是否过期;
            // 如果token有效时间没有过期
            if(dateState != null && dateState==2){
//                jsonResult.setErrorCode(GlobalConstants.admin_login_success_code);
                result = true;
            }else{
                JsonResult jsonResult = new JsonResult();
                // 登录超时
                jsonResult.setErrorCode(GlobalConstants.admin_overtime_login_code);
                jsonResult.setMessage(GlobalConstants.admin_overtime_login_message);
                result = false;
                StrUtil.dealErrorReturn(httpServletRequest,httpServletResponse,jsonResult);
            }
        }else{
            JsonResult jsonResult = new JsonResult();
            // token与对应的管理员id不一致
            jsonResult.setErrorCode(GlobalConstants.admin_not_login_code);
            jsonResult.setMessage(GlobalConstants.admin_not_login_message);
            result = false;
            StrUtil.dealErrorReturn(httpServletRequest,httpServletResponse,jsonResult);
        }
        return result;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
