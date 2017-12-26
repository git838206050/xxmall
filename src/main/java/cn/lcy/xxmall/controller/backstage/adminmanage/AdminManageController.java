package cn.lcy.xxmall.controller.backstage.adminmanage;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.Admin;
import cn.lcy.xxmall.pojo.common.JsonLayui;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.AdminService;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.Md5Util;
import cn.lcy.xxmall.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * 管理员管理
 * @Author LCY
 * @Date 2017/10/28 11:11
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/adminManage")
public class AdminManageController {
    @Autowired
    private AdminService adminService;

    /**
     * 分页获取所有管理员信息
     * @param page 当前页码
     * @param limit 每页显示的数量
     * @return
     */
    @RequestMapping(value = "/showAdmins")
    @ResponseBody
    public JsonLayui shopAdmins(@RequestParam(value = "page" , required = false) Integer page,
                                 @RequestParam(value = "limit" , required = false) Integer limit){
        // 默认显示第一页
        if(page == null || page < 1){
            page = 1;
        }
        // 默认每页显示5条
        if(limit == null || limit < 1){
            limit = 5;
        }
        JsonLayui jsonLayui = new JsonLayui();
        // 分页
        PageHelper.startPage(page,limit);
        List<Admin> adminList = adminService.getAdmins();
        PageInfo pageInfo = new PageInfo(adminList);
        if(adminList.size() > 0){
            jsonLayui.setCode(0);
            // 获取数据的总数
            jsonLayui.setCount( pageInfo.getTotal() );
            jsonLayui.setMsg(GlobalConstants.operaction_success_message);
//            jsonResult.setItem(map);
            jsonLayui.setData(jsonLayui.toObject(adminList));
        }else{
            jsonLayui.setCode(0);
            jsonLayui.setMsg(GlobalConstants.operaction_failed_message);
        }
        jsonLayui.setLimit(Long.valueOf(limit));
        jsonLayui.setPage(Long.valueOf(page));
        return jsonLayui;
    }

    /**
     * 执行修改昵称请求
     * @param adminId 执行该请求的管理员ID
     * @param targetId 被执行该操作的管理员ID
     * @param newNickname 新的昵称
     * @return
     */
    @PostMapping(value = "/updataAdminOfNickname")
    @ResponseBody
    public JsonResult updataAdminOfNickname(@RequestParam(value = "adminId")Integer adminId,
                                            @RequestParam(value = "targetId")Integer targetId,
                                            @RequestParam(value = "newNickname", required = true)String newNickname){
        JsonResult jsonResult = new JsonResult();
        Admin stateAdmin = adminService.getAdminByNickname(newNickname);
        if(stateAdmin!=null){
            // 该参数已存在
            jsonResult.setErrorCode(GlobalConstants.updata_failed_existed_code);
            jsonResult.setMessage(GlobalConstants.updata_failed_existed_message);
        }else {
            int state = adminService.updataAdminOfNickname(adminId, targetId, newNickname);
            // 0：修改失败; -1:修改失败，该管理员不存在； 1：修改成功； 2：修改失败，没有权限；（不会返回null） updata_failed_existed_message
            if (state == 1) {
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            } else if (state == 2) {
                jsonResult.setErrorCode(GlobalConstants.operation_not_authority_code);
                jsonResult.setMessage(GlobalConstants.operation_not_authority_message);
            } else if (state == -1) {
                jsonResult.setErrorCode(GlobalConstants.id_not_existent_code);
                jsonResult.setMessage(GlobalConstants.id_not_existent_message);
            } else {
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }
        return jsonResult;
    }

    /**
     * 执行修改昵称请求
     * @param adminId 执行该请求的管理员ID
     * @param targetId 被执行该操作的管理员ID
     * @param newEmail 新的昵称
     * @return
     */
    @PostMapping(value = "/updataAdminOfEmail")
    @ResponseBody
    public JsonResult updataAdminOfEmail(@RequestParam(value = "adminId")Integer adminId,
                                         @RequestParam(value = "targetId")Integer targetId,
                                         @RequestParam(value = "newEmail", required = true)String newEmail){
        JsonResult jsonResult = new JsonResult();
        Admin stateAdmin = adminService.getAdminByEmail(newEmail);
        if(stateAdmin!=null){
            // 该参数已存在
            jsonResult.setErrorCode(GlobalConstants.updata_failed_existed_code);
            jsonResult.setMessage(GlobalConstants.updata_failed_existed_message);
        }else {
            int state = adminService.updataAdminOfEmail(adminId, targetId, newEmail);
            // 0：修改失败; -1:修改失败，该管理员不存在； 1：修改成功； 2：修改失败，没有权限；（不会返回null）
            if (state == 1) {
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            } else if (state == 2) {
                jsonResult.setErrorCode(GlobalConstants.operation_not_authority_code);
                jsonResult.setMessage(GlobalConstants.operation_not_authority_message);
            } else if (state == -1) {
                jsonResult.setErrorCode(GlobalConstants.id_not_existent_code);
                jsonResult.setMessage(GlobalConstants.id_not_existent_message);
            } else {
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }
        return jsonResult;
    }

    /**
     * 用于更新管理员禁止登录时间
     * @param targetId 指定的管理员登录时间
     * @param newLoginTime 要修改的管理员禁止登陆时间
     * @return
     */
    @PostMapping(value = "/updataAdminOfLongTime")
    @ResponseBody
    public JsonResult updataAdminOfLongTime(@RequestParam(value = "adminId")Integer adminId,
                                            @RequestParam(value = "targetId")Integer targetId,
                                            @RequestParam(value = "newLoginTime")String newLoginTime){
        JsonResult jsonResult = new JsonResult();
        Integer updateState = 0;
        if(targetId == null || targetId<1 || newLoginTime==null){
            // 非法操作
            jsonResult.setErrorCode(GlobalConstants.illegal_operation_code);
            jsonResult.setMessage(GlobalConstants.illegal_operation_message);
        }else{
            updateState = adminService.updataAdminOfprohibitLoginTime(adminId, targetId, DateUtil.getDate(newLoginTime,1));
        }
        if(updateState!=null && updateState==1){
            // 操作成功
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }else if(updateState == 0){
            // 没有权限操作
            jsonResult.setErrorCode(GlobalConstants.operation_not_authority_code);
            jsonResult.setMessage(GlobalConstants.operation_not_authority_message);
        }else if(updateState == -1){
            // 不能对自己进行操作该动作
            jsonResult.setErrorCode(GlobalConstants.operation_not_oneself_code);
            jsonResult.setMessage(GlobalConstants.operation_not_oneself_message);
        }else{
            // 操作失败
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }

        return  jsonResult;
    }

    /**
     * 执行将指定管理放置回收站请求
     * @param targetId 需要放置回收站的管理员id
     * @param adminId 执行该操作的管理员id
     * @return
     */
    @PostMapping(value = "deleteAdminById")
    @ResponseBody
    public JsonResult deleteAdminById(@RequestParam(value = "targetId")Integer targetId,
                                      @RequestParam(value = "adminId")Integer adminId){
        JsonResult jsonResult = new JsonResult();
        Integer state = adminService.deleteAdminByAdminId(targetId, adminId);
        // 0：传入非法值； 1：回收成功； 2：回收失败，没有权限回收； 3:回收失败，不能删除自己；4:删除失败，该管理员id不存在
        if(state.equals(1)){
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }else if(state.equals(0)){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }else if(state.equals(2)){
            jsonResult.setErrorCode(GlobalConstants.operation_not_authority_code);
            jsonResult.setMessage(GlobalConstants.operation_not_authority_message);
        }else if(state.equals(3)){
            jsonResult.setErrorCode(GlobalConstants.operation_not_oneself_code);
            jsonResult.setMessage(GlobalConstants.operation_not_oneself_message);
        }else if(state.equals(4)){
            jsonResult.setErrorCode(GlobalConstants.id_not_existent_code);
            jsonResult.setMessage(GlobalConstants.id_not_existent_message);
        }
        return jsonResult;
    }

    @RequestMapping(value = "testFile")
    @ResponseBody
    public JsonResult testFile(@RequestParam(value="file[]",required=false) MultipartFile file[],
                               HttpServletRequest httpSeHttpServletRequest) throws IOException {

        JsonResult jsonResult = new JsonResult();
        byte[] abyte = file[0].getBytes();
        // 图片类型：
        // file.getSize() 文件大小。单位：b
        System.out.println("上传图片测试，图片类型："+ file[0].getContentType());
        System.out.println("上传图片测试，文件大小："+ file[0].getSize());
        System.out.println("上传图片测试，文件名称："+ file[0].getOriginalFilename());
        System.out.println("上传图片测试，2是否为空："+ file[0].isEmpty());
        System.out.println("上传图片测试，二进制：");
        BufferedImage bi = ImageIO.read(file[0].getInputStream());
        if(bi == null){
            System.out.println("不是");
        }else{
            System.out.println("xx");
        }
        System.out.println("图片：" + Md5Util.md5( StrUtil.newString(file[0].getBytes()) ));
        String filePath2 = httpSeHttpServletRequest.getSession().getServletContext().getRealPath("/") + "bgFileUpload\\admin\\header\\"
                + Md5Util.md5( DateUtil.convertDateToString( DateUtil.getDate(),1) )+".jpg";
        System.out.println("======================================="+filePath2);
//        String filePath = "G:\\xa.jpg";
//        file.transferTo(new File(filePath2));
        System.out.println("=======================================");
        return jsonResult;
    }

    /**
     * 多个文件上传测试，使用HTML5的multiple="multiple"
     * @param httpSeHttpServletRequest
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "testFile2")
    @ResponseBody
    public JsonResult testFile2(HttpServletRequest httpSeHttpServletRequest,
                               MultipartHttpServletRequest request) throws IOException {
        List<MultipartFile> files = request.getFiles("productImage");
        for (int i = 0; i < files.size(); i++) {
            System.out.println(files.get(i).getName()+i);
        }

        JsonResult jsonResult = new JsonResult();
        return jsonResult;
    }
}
