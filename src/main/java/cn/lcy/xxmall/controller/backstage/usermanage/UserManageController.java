package cn.lcy.xxmall.controller.backstage.usermanage;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.Admin;
import cn.lcy.xxmall.pojo.User;
import cn.lcy.xxmall.pojo.common.JsonLayui;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.UserService;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.FileUtilByLcy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/9 17:11
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/userManage")
public class UserManageController {
    @Autowired
    private UserService userService;

    protected JsonResult jsonResult;
    /**
     * 分页查询所有用户
     * @param page 当前页
     * @param limit 每页显示数量
     * @return
     */
    @RequestMapping(value = "/showUsers")
    @ResponseBody
    public JsonLayui showUsers(@RequestParam(value = "page", required = false)Integer page,
                               @RequestParam(value = "limit", required = false)Integer limit){
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
        List<User> userList = userService.getUsers();
        PageInfo pageInfo = new PageInfo(userList);
        // 获取数据的总数
        jsonLayui.setCount( pageInfo.getTotal() );

        if(userList.size() > 0) {
            jsonLayui.setData(jsonLayui.toObject(userList));
            jsonLayui.setCode(0);
        }else{
            jsonLayui.setCode(1);
        }
        jsonLayui.setLimit(Long.valueOf(limit));
        jsonLayui.setPage(Long.valueOf(page));
        return jsonLayui;
    }

    @RequestMapping(value = "/updateNickname")
    @ResponseBody
    public JsonResult updateNickname(@RequestParam(value = "nickname") String nickname,
                                     @RequestParam(value = "targetId") Integer targerId,
                                     @RequestParam(value = "adminId") Integer adminId){
        jsonResult = new JsonResult();
        int state = 0;
        if(targerId!=null && adminId!=null){
            state = userService.updateUserOfNickname(adminId, targerId, nickname);
        }
        jsonResultSet(state);
        return jsonResult;
    }

    @RequestMapping(value = "/updateEmail")
    @ResponseBody
    public JsonResult updateEmail(@RequestParam(value = "email") String email,
                                  @RequestParam(value = "targetId") Integer targerId,
                                  @RequestParam(value = "adminId") Integer adminId){
        jsonResult = new JsonResult();
        int state = 0;
        if(targerId!=null && adminId!=null){
            state = userService.updateUserOfEmail(adminId, targerId, email);
        }
        jsonResultSet(state);
        return jsonResult;
    }

    @RequestMapping(value = "/updateQuestion")
    @ResponseBody
    public JsonResult updateQuestion(@RequestParam(value = "question") String question,
                                     @RequestParam(value = "targetId") Integer targerId,
                                     @RequestParam(value = "adminId") Integer adminId){
        jsonResult = new JsonResult();
        int state = 0;
        if(targerId!=null && adminId!=null){
            state = userService.updateUserOfQuestion(adminId, targerId, question);
        }
        jsonResultSet(state);
        return jsonResult;
    }

    @RequestMapping(value = "/updateAnswer")
    @ResponseBody
    public JsonResult updateAnswer(@RequestParam(value = "answer") String answer,
                                   @RequestParam(value = "targetId") Integer targerId,
                                   @RequestParam(value = "adminId") Integer adminId){
        jsonResult = new JsonResult();
        int state = 0;
        if(targerId!=null && adminId!=null){
            state = userService.updateUserOfAnswer(adminId, targerId, answer);
        }
        jsonResultSet(state);
        return jsonResult;
    }

    @PostMapping(value = "/updateProhibitLoginTime")
    @ResponseBody
    public JsonResult updateProhibitLoginTime(@RequestParam(value = "prohibitLoginTime") String prohibitLoginTime,
                                              @RequestParam(value = "targetId") Integer targerId,
                                              @RequestParam(value = "adminId") Integer adminId){
        jsonResult = new JsonResult();
        int state = 0;
        if(targerId!=null && adminId!=null && !prohibitLoginTime.equals("")){
            state = userService.updateUserOfProhibitLoginTime(adminId, targerId, DateUtil.getDate(prohibitLoginTime,1));
        }else{
            state = -2;
        }
        jsonResultSet(state);
        return jsonResult;
    }

    @PostMapping(value = "/insertUser")
    @ResponseBody
    public JsonResult insertUser(User user,
                                 @RequestParam(value = "header", required = false)MultipartFile file,
                                 @RequestParam(value = "adminId") Integer adminId){
        jsonResult = new JsonResult();
        int state = 0;
        if(adminId!=null){
            state = userService.insertUser(adminId, user,file);
        }else{
            state = -2;
        }
        jsonResultSet(state);
        return jsonResult;
    }

    @PostMapping(value = "/deleteUser")
    @ResponseBody
    public JsonResult deleteUser(@RequestParam(value = "targetId", required = true)Integer targetId,
                                 @RequestParam(value = "adminId") Integer adminId){
        jsonResult = new JsonResult();
        int state = 0;
        if(adminId!=null){
            state = userService.deleteUserByUserId(adminId,targetId);
        }else{
            state = -2;
        }
        jsonResultSet(state);
        return jsonResult;
    }

    /**
     * 验证表单信息时的赋值
     * @param state
     */
    protected void jsonResultSet(int state){
        if(state == 1){
            jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
            jsonResult.setMessage(GlobalConstants.operaction_success_message);
        }else if(state == 2){
            jsonResult.setErrorCode(GlobalConstants.operation_not_authority_code);
            jsonResult.setMessage(GlobalConstants.operation_not_authority_message);
        }else if(state == -1){
            jsonResult.setErrorCode(GlobalConstants.id_not_existent_code);
            jsonResult.setMessage(GlobalConstants.id_not_existent_message);
        }else if(state == -2){
            jsonResult.setErrorCode(GlobalConstants.illegal_operation_code);
            jsonResult.setMessage(GlobalConstants.illegal_operation_message);
        }else if(state == -3){
            jsonResult.setErrorCode(GlobalConstants.updata_failed_existed_code);
            jsonResult.setMessage(GlobalConstants.updata_failed_existed_message);
        }else{
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
    }
}
