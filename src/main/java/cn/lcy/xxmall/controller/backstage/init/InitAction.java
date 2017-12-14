package cn.lcy.xxmall.controller.backstage.init;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.PageMessage;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.GlobalConstantsInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 初始化类
 * 执行tomcat后不需要访问web地址直接执行的类
 */

@Controller
@RequestMapping(value = "/xxmall/backstage/")
public class InitAction extends HttpServlet {
    @Autowired
    private GlobalConstantsInitService globalConstantsInitService;

    private static ServletConfig  sConfig;

    /**
     * 给前台一个地址用于 输出至前台的数据在数据库被更改了的时候，初始化变量
     * @return
     * @throws ServletException
     */
    @RequestMapping(value = "/initAction")
    @ResponseBody
    public JsonResult initAction() throws ServletException{
        System.out.println("init================================");
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult.setErrorCode("200");
            jsonResult.setMessage("初始化成功！");
            new InitAction().init(sConfig);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonResult;
    }

    /**
     * 启动tomcat时执行的初始化动作
     * @param config
     * @throws ServletException
     */
    public void init(ServletConfig config ) throws ServletException{
        try {
            sConfig = config;
            // 添加注入方法，如果没有这一段将获取不到adminService
            SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
            // 初始化输出至前台的信息变量
            GlobalConstants globalConstants = new GlobalConstants();
            Map<String, String> messageMap = new HashMap<String, String>();
            // 获取所有变量
            List<PageMessage> pageMessageList = globalConstantsInitService.getMessages();
            for (int i = 0; i < pageMessageList.size(); i++) {
                messageMap.put(pageMessageList.get(i).getMessagekey() + "_message", pageMessageList.get(i).getMessagevalue());
                messageMap.put(pageMessageList.get(i).getMessagekey() + "_code", pageMessageList.get(i).getCode());
            }
            // 登录失败
            globalConstants.admin_login_failed_message = messageMap.get("admin_login_failed_message");
            globalConstants.admin_login_failed_code = messageMap.get("admin_login_failed_code");

            // 登录成功
            globalConstants.admin_login_success_message = messageMap.get("admin_login_success_message");
            globalConstants.admin_login_success_code = messageMap.get("admin_login_success_code");

            // 禁止登陆
            globalConstants.admin_login_prohibit_message = messageMap.get("admin_login_prohibit_message");
            globalConstants.admin_login_prohibit_code = messageMap.get("admin_login_prohibit_code");

            // 登录拦截器返回给ajax时所需要到的 地址链接头
            globalConstants.ajax_host = messageMap.get("ajax_host_message");

            // 访问到需要管理员登录权限的页面时，没有进行登录
            globalConstants.admin_not_login_message = messageMap.get("admin_not_login_message");
            globalConstants.admin_not_login_code = messageMap.get("admin_not_login_code");

            // 登录超时
            globalConstants.admin_overtime_login_message = messageMap.get("admin_overtime_login_message");
            globalConstants.admin_overtime_login_code = messageMap.get("admin_overtime_login_code");

            // 基本操作成功
            globalConstants.operaction_success_message = messageMap.get("operaction_success_message");
            globalConstants.operaction_success_code = messageMap.get("operaction_success_code");

            // 基本操作失败
            globalConstants.operaction_failed_message = messageMap.get("operaction_failed_message");
            globalConstants.operaction_failed_code = messageMap.get("operaction_failed_code");

            // 非法操作
            globalConstants.illegal_operation_message = messageMap.get("illegal_operation_message");
            globalConstants.illegal_operation_code = messageMap.get("illegal_operation_code");

            // 没有操作权限
            globalConstants.operation_not_authority_message = messageMap.get("operation_not_authority_message");
            globalConstants.operation_not_authority_code = messageMap.get("operation_not_authority_code");

            // 不能对自己执行该操作
            globalConstants.operation_not_oneself_message = messageMap.get("operation_not_oneself_message");
            globalConstants.operation_not_oneself_code = messageMap.get("operation_not_oneself_code");

            // 该对象不存在
            globalConstants.id_not_existent_message = messageMap.get("id_not_existent_message");
            globalConstants.id_not_existent_code = messageMap.get("id_not_existent_code");

            // 修改失败，该参数已存在
            globalConstants.updata_failed_existed_message = messageMap.get("updata_failed_existed_message");
            globalConstants.updata_failed_existed_code = messageMap.get("updata_failed_existed_code");

            // 验证管理员上传头像图片。成功状态
            globalConstants.admin_validate_header_success_message = messageMap.get("admin_validate_header_success_message");
            globalConstants.admin_validate_header_success_code = messageMap.get("admin_validate_header_success_code");

            // 上传的文件大小为0k时。
            globalConstants.validate_file_null_message = messageMap.get("validate_file_null_message");
            globalConstants.validate_file_null_code = messageMap.get("validate_file_null_code");

            // 文件过大。
            globalConstants.validate_file_excess_message = messageMap.get("validate_file_excess_message");
            globalConstants.validate_file_excess_code = messageMap.get("validate_file_excess_code");

            // 文件类型不一致
            globalConstants.validate_file_atypism_message = messageMap.get("validate_file_atypism_message");
            globalConstants.validate_file_atypism_code = messageMap.get("validate_file_atypism_code");

            // 文件错误。如：文件是jpg后缀，但是错误、不能显示的图片；
            globalConstants.validate_file_error_message = messageMap.get("validate_file_error_message");
            globalConstants.validate_file_error_code = messageMap.get("validate_file_error_code");

            // 验证用户
            globalConstants.username_existent_message = messageMap.get("username_existent_message");
            globalConstants.username_existent_code = messageMap.get("username_existent_code");

            globalConstants.username_format_error_message = messageMap.get("username_format_error_message");
            globalConstants.username_format_error_code = messageMap.get("username_format_error_code");

            globalConstants.validate_user_nickname_existent_message = messageMap.get("validate_user_nickname_existent_message");
            globalConstants.validate_user_nickname_existent_code = messageMap.get("validate_user_nickname_existent_code");

            globalConstants.validate_user_nickname_length_message = messageMap.get("validate_user_nickname_length_message");
            globalConstants.validate_user_nickname_length_code = messageMap.get("validate_user_nickname_length_code");

            globalConstants.validate_user_email_existent_message = messageMap.get("validate_user_email_existent_message");
            globalConstants.validate_user_email_existent_code = messageMap.get("vvalidate_user_email_existent_code");

            globalConstants.validate_user_email_error_message = messageMap.get("validate_user_email_error_message");
            globalConstants.validate_user_email_error_code = messageMap.get("validate_user_email_error_code");

            globalConstants.validate_user_question_length_message = messageMap.get("validate_user_question_length_message");
            globalConstants.validate_user_question_length_code = messageMap.get("validate_user_question_length_code");

            globalConstants.validate_user_answer_length_message = messageMap.get("validate_user_answer_length_message");
            globalConstants.validate_user_answer_length_code = messageMap.get("validate_user_answer_length_code");

            globalConstants.validate_shop_username_not_existent_message = messageMap.get("validate_shop_username_not_existent_message");
            globalConstants.validate_shop_username_not_existent_code = messageMap.get("validate_shop_username_not_existent_code");

            globalConstants.validate_shop_name_existent_message = messageMap.get("validate_shop_name_existent_message");
            globalConstants.validate_shop_name_existent_code = messageMap.get("validate_shop_name_existent_code");

            globalConstants.validate_shop_userid_existent_message = messageMap.get("validate_shop_userid_existent_message");
            globalConstants.validate_shop_userid_existent_code = messageMap.get("validate_shop_userid_existent_code");

            // 测试
//            System.out.println("===================================3x" + globalConstants.admin_login_prohibit_message);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
//                System.out.println("-------设定要指定任务--------");
                }
            }, 2000);// 设定指定的时间time,此处为2000毫秒
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
