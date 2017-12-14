package cn.lcy.xxmall.controller.backstage.usermanage;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.User;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.UserService;
import cn.lcy.xxmall.util.FileUtilByLcy;
import cn.lcy.xxmall.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author LCY
 * @Date 2017/11/10 9:07
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/userManage/userQuery")
public class UserQueryController {
    @Autowired
    private UserService userService;

    protected User user = null;

    /**
     * 验证用户名
     * @param username
     * @return
     */
    @PostMapping(value = "validataUsername")
    @ResponseBody
    public JsonResult validataUserName(@RequestParam(value = "username") String username){
        JsonResult jsonResult = new JsonResult();
        user = userService.getUserByUsername(username);
        if(user!=null){
            // 用户名存在
            jsonResult.setErrorCode(GlobalConstants.username_existent_code);
            jsonResult.setMessage(GlobalConstants.username_existent_message);
        }else if(username.length()<5 || username.length()>20){
            // 用户名格式不对
            jsonResult.setErrorCode(GlobalConstants.username_format_error_code);
            jsonResult.setMessage(GlobalConstants.username_format_error_message);
        }else{
            // 验证通过
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }
        return jsonResult;
    }

    /**
     * 验证昵称
     * @param nickname
     * @return
     */
    @PostMapping(value = "validataNickname")
    @ResponseBody
    public JsonResult validataNickname(@RequestParam(value = "nickname") String nickname){
        JsonResult jsonResult = new JsonResult();
        user = userService.getUserByNickname(nickname);
        if(user!=null){
            // 昵称存在
            jsonResult.setErrorCode(GlobalConstants.validate_user_nickname_existent_code);
            jsonResult.setMessage(GlobalConstants.validate_user_nickname_existent_message);
        }else if(nickname.length()<5 || nickname.length()>20){
            // 用户名格式不对
            jsonResult.setErrorCode(GlobalConstants.validate_user_nickname_length_code);
            jsonResult.setMessage(GlobalConstants.validate_user_nickname_length_message);
        }else{
            // 验证通过
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }
        return jsonResult;
    }

    @PostMapping(value = "validataEmail")
    @ResponseBody
    public JsonResult validataEmail(@RequestParam(value = "email") String email){
        JsonResult jsonResult = new JsonResult();
        user = userService.getUserByEmail(email);
        if(user!=null){
            // 邮箱存在
            jsonResult.setErrorCode(GlobalConstants.validate_user_email_existent_code);
            jsonResult.setMessage(GlobalConstants.validate_user_email_existent_message);
        }else if(!StrUtil.validateEmail(email)){
            // 邮箱格式不对
            jsonResult.setErrorCode(GlobalConstants.validate_user_email_error_code);
            jsonResult.setMessage(GlobalConstants.validate_user_email_error_message);
        }else{
            // 验证通过
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }
        return jsonResult;
    }

    @PostMapping(value = "validataQuestion")
    @ResponseBody
    public JsonResult validataQuestion(@RequestParam(value = "question") String question){
        JsonResult jsonResult = new JsonResult();
        if(question.length()<2 || question.length()>20){
            // 问题格式不对
            jsonResult.setErrorCode(GlobalConstants.validate_user_question_length_code);
            jsonResult.setMessage(GlobalConstants.validate_user_question_length_message);
        }else{
            // 验证通过
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }
        return jsonResult;
    }

    @PostMapping(value = "validataAnswer")
    @ResponseBody
    public JsonResult validataAnswer(@RequestParam(value = "answer") String answer){
        JsonResult jsonResult = new JsonResult();
        if(answer.length()<2 || answer.length()>20){
            // 邮箱格式不对
            jsonResult.setErrorCode(GlobalConstants.validate_user_answer_length_message);
            jsonResult.setMessage(GlobalConstants.validate_user_answer_length_message);
        }else{
            // 验证通过
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }
        return jsonResult;
    }

    @PostMapping(value = "/validateUserHeader")
    @ResponseBody
    public JsonResult validateUserHeader(@RequestParam(value = "header", required = true)MultipartFile file){
        JsonResult jsonResult = new JsonResult();
        String[] fileType = {"jpg"};                // 上传管理员头像的文件后缀名
        String fileCatalog = "user\\header\\";     // 上传管理员头像的文件相对目录
        Long fileMaxSize = 512000L;                // 文件最大限制.单位为b
        String state = FileUtilByLcy.uploadImageFile(file,fileMaxSize,fileType,fileCatalog,true,(byte)1);
        // 0：上传失败，未知错误；1（验证模式）:上传成功;  -1:文件为空； -2：文件过大； -3：文件类型不一致； -4：文件是jpg后缀，但是错误、不能显示的图片；
        if(state.equals("1")){
            // 文件合理
            jsonResult.setErrorCode(GlobalConstants.admin_validate_header_success_code);
            jsonResult.setMessage(GlobalConstants.admin_validate_header_success_message);
        }else if(state.equals("-1")){
            // 文件为空
            jsonResult.setErrorCode(GlobalConstants.validate_file_null_code);
            jsonResult.setMessage(GlobalConstants.validate_file_null_message);
        }else if(state.equals("-2")){
            // 文件过大
            jsonResult.setErrorCode(GlobalConstants.validate_file_excess_code);
            jsonResult.setMessage(GlobalConstants.validate_file_excess_message+"头像文件不能超500kb");
        }else if(state.equals("-3")){
            // 文件类型不一致
            jsonResult.setErrorCode(GlobalConstants.validate_file_atypism_code);
            jsonResult.setMessage(GlobalConstants.validate_file_atypism_message);
        }else if(state.equals("-4")){
            // 文件错误
            jsonResult.setErrorCode(GlobalConstants.validate_file_error_code);
            jsonResult.setMessage(GlobalConstants.validate_file_error_message);
        }else{
            // 未知异常
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

}
