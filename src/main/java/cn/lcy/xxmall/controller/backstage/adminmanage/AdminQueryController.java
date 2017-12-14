package cn.lcy.xxmall.controller.backstage.adminmanage;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.dao.AdminMapper;
import cn.lcy.xxmall.pojo.Admin;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.AdminService;
import cn.lcy.xxmall.util.FileUtilByLcy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 管理员查询
 * @Author LCY
 * @Date 2017/11/4 14:29
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/adminQuery")
public class AdminQueryController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/queryAdminName")
    @ResponseBody
    public JsonResult queryAdminByAdminName(@RequestParam(value = "adminName", required = true)String adminName){
        JsonResult jsonResult = new JsonResult();
        Admin admin = adminService.getAdminByAdminName(adminName);
        if(admin != null){
            // 查询对象存在
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
        }else{
            // 查询对象不存在
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
        }
        return jsonResult;
    }

    @PostMapping(value = "/queryNickname")
    @ResponseBody
    public JsonResult queryAdminByNickname(@RequestParam(value = "nickname", required = true)String nickname){
        JsonResult jsonResult = new JsonResult();
        Admin admin = adminService.getAdminByNickname(nickname);
        if(admin != null){
            // 查询对象存在
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
        }else{
            // 查询对象不存在
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
        }
        return jsonResult;
    }

    @PostMapping(value = "/queryEmail")
    @ResponseBody
    public JsonResult queryAdminByEmail(@RequestParam(value = "email", required = true)String email){
        JsonResult jsonResult = new JsonResult();
        Admin admin = adminService.getAdminByEmail(email);
        if(admin != null){
            // 查询对象存在
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
        }else{
            // 查询对象不存在
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
        }
        return jsonResult;
    }

    @PostMapping(value = "/validateAdminHeader")
    @ResponseBody
    public JsonResult validateAdminHeader(@RequestParam(value = "header", required = true)MultipartFile file){
        JsonResult jsonResult = new JsonResult();
        String[] fileType = {"jpg"};                // 上传管理员头像的文件后缀名
        String fileCatalog = "admin\\header\\";     // 上传管理员头像的文件相对目录
        Long fileMaxSize = 1048576L;                // 文件最大限制,1048576L：1m。单位为b
        String state = FileUtilByLcy.uploadImageFile(file,fileMaxSize,fileType,fileCatalog,true,(byte)0);
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
            jsonResult.setMessage(GlobalConstants.validate_file_excess_message+"头像文件不能超过1m");
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
