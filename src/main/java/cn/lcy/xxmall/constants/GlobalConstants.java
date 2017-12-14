package cn.lcy.xxmall.constants;

import cn.lcy.xxmall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 该类保存的信息用于输出于前台显示
 * 信息的值从数据库里面获取
 */
public class GlobalConstants{
    /**
     * 后台文件上传路径后面还需加文件夹分层
     * 在controller 使用httpSeHttpServletRequest.getSession().getServletContext().getRealPath("/") 获取该路径。
     * 每第一次配置该项目时均需要配置
     */
    public static String bgFileUploadUrl = "G:\\data\\idea\\xxmall\\target\\xxmall\\bgFileUpload\\";
    public static String fdFileUploadUrl = "G:\\data\\idea\\xxmall\\target\\xxmall\\fdFileUpload\\";

    // 管理员登录失败
    public static String admin_login_failed_message;
    public static String admin_login_failed_code;

    // 管理员登录成功
    public static String admin_login_success_message;
    public static String admin_login_success_code;

    // 禁止管理员登录
    public static String admin_login_prohibit_message;
    public static String admin_login_prohibit_code;

    // 登录拦截器返回给ajax时所需要到的 地址链接头
    public static String ajax_host;

    // 访问到需要管理员登录权限的页面时，没有进行登录
    public static String admin_not_login_message;
    public static String admin_not_login_code;

    // 登录超时
    public static String admin_overtime_login_message;
    public static String admin_overtime_login_code;

    // 基本操作成功
    public static String operaction_success_message;
    public static String operaction_success_code;

    // 基本操作失败
    public static String operaction_failed_message;
    public static String operaction_failed_code;

    // 非法操作
    public static String illegal_operation_message;
    public static String illegal_operation_code;

    // 没有操作权限
    public static String operation_not_authority_message;
    public static String operation_not_authority_code;

    // 不能对自己执行该操作
    public static String operation_not_oneself_message;
    public static String operation_not_oneself_code;

    // 该对象不存在
    public static String id_not_existent_message;
    public static String id_not_existent_code;

    // 该参数已存在
    public static String updata_failed_existed_message;
    public static String updata_failed_existed_code;

    //========================================================= 验证管理员上传文件
    // 验证管理员上传头像图片。成功状态
    public static String admin_validate_header_success_message;
    public static String admin_validate_header_success_code;

    // 上传的文件大小为0k时。
    public static String validate_file_null_message;
    public static String validate_file_null_code;

    // 文件过大。
    public static String validate_file_excess_message;
    public static String validate_file_excess_code;

    // 文件类型不一致
    public static String validate_file_atypism_message;
    public static String validate_file_atypism_code;

    // 文件错误。如：文件是jpg后缀，但是错误、不能显示的图片；
    public static String validate_file_error_message;
    public static String validate_file_error_code;
    //========================================================= 验证管理员上传文件end

    // 用户验证
    public static String username_existent_message;
    public static String username_existent_code;

    public static String username_format_error_message;
    public static String username_format_error_code;

    public static String validate_user_nickname_existent_message;
    public static String validate_user_nickname_existent_code;

    public static String validate_user_nickname_length_message;
    public static String validate_user_nickname_length_code;

    public static String validate_user_email_existent_message;
    public static String validate_user_email_existent_code;

    public static String validate_user_email_error_message;
    public static String validate_user_email_error_code;

    public static String validate_user_question_length_message;
    public static String validate_user_question_length_code;

    public static String validate_user_answer_length_message;
    public static String validate_user_answer_length_code;

    // 店铺验证
    public static String validate_shop_username_not_existent_message;
    public static String validate_shop_username_not_existent_code;

    public static String validate_shop_name_existent_message;
    public static String validate_shop_name_existent_code;

    public static String validate_shop_userid_existent_message;
    public static String validate_shop_userid_existent_code;

}
