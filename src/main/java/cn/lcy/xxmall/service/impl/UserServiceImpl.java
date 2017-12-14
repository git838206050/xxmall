package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.FdImageMapper;
import cn.lcy.xxmall.dao.UserMapper;
import cn.lcy.xxmall.pojo.*;
import cn.lcy.xxmall.service.UserService;
import cn.lcy.xxmall.service.common.BaseService;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.FileUtilByLcy;
import cn.lcy.xxmall.util.Md5Util;
import cn.lcy.xxmall.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/8 12:24
 */
@Service
public class UserServiceImpl extends BaseService implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FdImageMapper fdImageMapper;

    private UserExample userExample;
    protected User user;

    @Override
    public List<User> getUsers() {
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andRecoveryIsNull();
        return userMapper.selectByExample(userExample);
    }

    @Override
    public User login(String userName, String password) {
        List<User> userList;
        password = Md5Util.md5(password,(byte)0);
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andUsernameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        userList = userMapper.selectByExample(userExample);
        if(userList.size() > 0){
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public User getUserByUsername(String userName) {
        user = null;
        List<User> userList;
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andUsernameEqualTo(userName);
        userList = userMapper.selectByExample(userExample);
        if(userList.size() > 0){
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public User getUserByNickname(String nickname) {
        user = null;
        List<User> userList;
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andNicknameEqualTo(nickname);
        userList = userMapper.selectByExample(userExample);
        if(userList.size() > 0){
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        user = null;
        List<User> userList;
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andEmailEqualTo(email);
        userList = userMapper.selectByExample(userExample);
        if(userList.size() > 0){
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public User getUserByQuestion(String question) {
        user = null;
        List<User> userList;
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andQuestionEqualTo(question);
        userList = userMapper.selectByExample(userExample);
        if(userList.size() > 0){
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public User getUserByAnswer(String answer) {
        user = null;
        List<User> userList;
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andAnswerEqualTo(answer);
        userList = userMapper.selectByExample(userExample);
        if(userList.size() > 0){
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public int deleteUserByUserId(int adminId, int targetId) {
        int state = 0;
        state = validate(5,adminId,targetId);

        if(state == 1){
            user.setRecovery((byte)1);
            if(userMapper.updateByPrimaryKeySelective(user) == 1){
                state = 1;
            }else{
                state = 0;
            }
        }
        return state;
    }

    @Override
    public int updateUser(int targetId, int userId, User user) {
        int state = 0;
        List<User> userList;
        User oUser;
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        // 因为是前台的操作，所有更新只能对自己的数据进行更新
        if(targetId == userId && user!=null){
            oUser = userMapper.selectByPrimaryKey(userId);
            oUser.setAnswer(user.getAnswer());
            oUser.setEmail(user.getEmail());
            oUser.setNickname(user.getNickname());
            if(userMapper.updateByPrimaryKey(oUser) == 1){
                state = 1;
            }else{
                state = 0;
            }
        }else{
            state = -2;
        }
        return state;
    }

    @Override
    public int updateUserOfPassword(int adminId, int targetId, String password) {
        int state = 0;

        state = validate(4,adminId,targetId);
        if(password.length()>=5 || password.length()<=20){
            state = 1;
        }else{
            // 密码格式不对
            state = -2;
        }

        if(state == 1){
            user.setPassword(password);
            if(userMapper.updateByPrimaryKeySelective(user) == 1){
                state = 1;
            }else{
                state = 0;
            }
        }

        return state;
    }

    @Override
    public int updateUserOfNickname(int adminId, int targetId, String nickname) {
        user = null;
        int state = 0;
        state = validate(4,adminId,targetId);
        if(nickname.length()<5 || nickname.length()>15){
            state = -2;
        }
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andNicknameEqualTo(nickname);
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList.size() > 0){
            state = -3;
        }

        if(state == 1){
            user.setNickname(nickname);
            if(userMapper.updateByPrimaryKeySelective(user) == 1){
                state = 1;
            }else{
                state = 0;
            }
        }
        return state;
    }

    @Override
    public int updateUserOfEmail(int adminId, int targetId, String email) {
        int state = 0;
        state = validate(4,adminId,targetId);
        if(!StrUtil.validateEmail(email)){
            state = -2;
        }
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList.size() > 0){
            state = -3;
        }

        if(state == 1){
            user.setEmail(email);
            if(userMapper.updateByPrimaryKeySelective(user) == 1){
                state = 1;
            }else{
                state = 0;
            }
        }
        return state;
    }

    @Override
    public int updateUserOfLevel(int adminId, int targetId, int level) {
        int state = 0;
        state = validate(4,adminId,targetId);
        if(level<0 || level>20){
            state = -2;
        }

        if(state == 1){
            user.setLevel(level);
            if(userMapper.updateByPrimaryKeySelective(user) == 1){
                state = 1;
            }else{
                state = 0;
            }
        }
        return state;
    }

    @Override
    public int updateUserOfQuestion(int adminId, int targetId, String question) {
        int state = 0;
        state = validate(4,adminId,targetId);
        if(question.length()<5 || question.length()>20){
            state = -2;
        }

        if(state == 1){
            user.setQuestion(question);
            if(userMapper.updateByPrimaryKeySelective(user) == 1){
                state = 1;
            }else{
                state = 0;
            }
        }
        return state;
    }

    @Override
    public int updateUserOfAnswer(int adminId, int targetId, String answer) {
        int state = 0;
        state = validate(4,adminId,targetId);
        if(answer.length()<3 || answer.length()>20){
            state = -2;
        }

        if(state == 1){
            user.setAnswer(answer);
            if(userMapper.updateByPrimaryKeySelective(user) == 1){
                state = 1;
            }else{
                state = 0;
            }
        }
        return state;
    }

    @Override
    public int updateUserOfProhibitLoginTime(int adminId, int targetId, Date prohibitLoginTime) {
        int state = 0;
        state = validate(4,adminId,targetId);
        if(prohibitLoginTime == null){
            state = -2;
        }
        if(state == 1){
            user.setProhibitlogintime(prohibitLoginTime);
            if(userMapper.updateByPrimaryKeySelective(user) == 1){
                state = 1;
            }else{
                state = 0;
            }
        }
        return state;
    }

    @Override
    public int insertUser(int adminId,User user,MultipartFile userHeaderFile) {
        int state = 0;
        if(user == null){
            // 对象为空
            state = -2;
        }
        if(!super.isAuthorize(6,adminId)){
            // 没有权限
            state = 2;
        }

        // 验证字段
        if(state == 0) {
            // 验证邮箱是否重复
            userExample = new UserExample();
            UserExample.Criteria criteria = userExample.or();
            criteria.andEmailEqualTo(user.getEmail());
            List<User> userList = userMapper.selectByExample(userExample);

            if (userList.size() > 0) {
                state = -1;
            }else{
                state = 0;
            }

            // 验证账号是否重复
            userExample = new UserExample();
            criteria = userExample.or();
            criteria.andUsernameEqualTo(user.getUsername());
            userList = userMapper.selectByExample(userExample);

            if (userList.size() > 0) {
                state = -1;
            }else{
                state = 0;
            }

            // 验证昵称是否重复
            userExample = new UserExample();
            criteria = userExample.or();
            criteria.andNicknameEqualTo(user.getNickname());
            userList = userMapper.selectByExample(userExample);

            if (userList.size() > 0) {
                state = -1;
            }else{
                state = 0;
            }
        }

        try {
            // 上传文件
            if (state==0 && userHeaderFile != null) {
                // 图片密文
                String fileCiphertext = Md5Util.md5(StrUtil.newString(userHeaderFile.getBytes()));

                FdImageExample fdImageExample = new FdImageExample();
                FdImageExample.Criteria fdImageCriteria = fdImageExample.or();
                fdImageCriteria.andImageencrypeEqualTo(fileCiphertext);
                List<FdImage> fdImageList = fdImageMapper.selectByExample(fdImageExample);

                // 如果该图片有其他用户使用过
                if (fdImageList.size() == 0) {
                    String[] fileType = {"jpg"};                // 上传管理员头像的文件后缀名
                    String fileCatalog = "images\\";     // 上传管理员头像的文件相对目录
                    Long fileMaxSize = 512000L;                // 文件最大限制。单位为b
                    String userHeaderUrl = FileUtilByLcy.uploadImageFile(userHeaderFile, fileMaxSize, fileType, fileCatalog, false,(byte)1);
                    FdImage fdImage = new FdImage();
                    if (userHeaderUrl.length() > 5) {
                        // 管理员头像上传成功在保存至数据库
                        user.setHeaderurl(userHeaderUrl);
                        fdImage.setImageurl(userHeaderUrl);
                        fdImage.setImageencrype(fileCiphertext);
                        fdImage.setUsenum(1);
                        fdImageMapper.insert(fdImage);
                    }

                } else {
                    user.setHeaderurl(fdImageList.get(0).getImageurl());
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        if (state == 0) {
            user.setCreattime(DateUtil.getDate());
            user.setStoreid(null);
            user.setLevel(0);
            user.setRecovery(null);
            user.setProhibitlogintime(null);
            state = userMapper.insert(user);
        }

        return state;
    }

    /**
     * 验证字段与权限
     * @param purviewId 权限id
     * @param adminId 管理员id
     * @param targerId 对象id
     * @return
     */
    protected int validate(int purviewId,int adminId,int targerId){
        int state = 0;
        if(super.isAuthorize(4,adminId)){
            user = userMapper.selectByPrimaryKey(targerId);
            if(user != null){
                state = 1;
            }else{
                // 用户不存在
                state = -1;
            }
        }else{
            // 没有权限
            state = 2;
        }
        return state;
    }
}
