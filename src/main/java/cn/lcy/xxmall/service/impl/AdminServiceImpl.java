package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.dao.AdminMapper;
import cn.lcy.xxmall.dao.BgImageMapper;
import cn.lcy.xxmall.pojo.Admin;
import cn.lcy.xxmall.pojo.AdminExample;
import cn.lcy.xxmall.pojo.BgImage;
import cn.lcy.xxmall.pojo.BgImageExample;
import cn.lcy.xxmall.service.AdminService;
import cn.lcy.xxmall.service.common.BaseService;
import cn.lcy.xxmall.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl extends BaseService implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private BgImageMapper bgImageMapper;

    @Override
    public int insert(Integer adminId,Admin admin,MultipartFile adminHeader) {
        int state = 0;
        try{
            // 验证权限
            if(super.isAuthorize(3,adminId)) {
                // 验证密码长度
                if(admin.getPassword().length() >= 5 && admin.getPassword().length()<=20) {
                    admin.setPassword(Md5Util.md5(admin.getPassword()));
                    // 如果图片文件不为空
                    if(adminHeader!=null) {
                        // 图片密文
                        String fileCiphertext = Md5Util.md5(StrUtil.newString(adminHeader.getBytes()));

                        BgImageExample bgImageExample = new BgImageExample();
                        BgImageExample.Criteria bgImageCriteria = bgImageExample.or();
                        bgImageCriteria.andImageencryptEqualTo(fileCiphertext);
                        List<BgImage> bgImageList = bgImageMapper.selectByExample(bgImageExample);

                        // 如果该图片有其他用户使用过
                        if (bgImageList.size() == 0) {
                            String[] fileType = {"jpg"};                // 上传管理员头像的文件后缀名
                            String fileCatalog = "images\\";     // 上传管理员头像的文件相对目录
                            Long fileMaxSize = 1048576L;                // 文件最大限制,1048576L：1m。单位为b
                            String adminHeaderUrl = FileUtilByLcy.uploadImageFile(adminHeader, fileMaxSize, fileType, fileCatalog, false,(byte)0);
                            BgImage bgImage = new BgImage();
                            if (adminHeaderUrl.length() > 5) {
                                // 管理员头像上传成功在保存至数据库
                                admin.setHeaderurl(adminHeaderUrl);
                                bgImage.setImageurl(adminHeaderUrl);
                                bgImage.setImageencrypt(fileCiphertext);
                                bgImage.setUsenum(1);
                                bgImageMapper.insert(bgImage);
                            }

                        } else {
                            admin.setHeaderurl(bgImageList.get(0).getImageurl());
                        }
                        admin.setCreattime(DateUtil.getDate());
                    }
                    state = adminMapper.insert(admin);
                }else{
                    state = -1;
                }
            }else{
                state = 2;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

    @Override
    public Admin login(String adminName, String password) {
        password = Md5Util.md5(password);
        Admin admin = null;
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.or();
        criteria.andAdminnameEqualTo(adminName).andPasswordEqualTo(password);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList.size() == 1){
            admin = adminList.get(0);
        }
        return admin;
    }

    @Override
    public Admin getAdminByAdminName(String adminName) {
        Admin admin = null;
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.or();
        criteria.andAdminnameEqualTo(adminName);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList.size() > 0){
            admin = adminList.get(0);
        }
        return admin;
    }

    @Override
    public Admin getAdminByNickname(String nickname) {
        Admin admin = null;
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.or();
        criteria.andNicknameEqualTo(nickname);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList.size() > 0){
            admin = adminList.get(0);
        }
        return admin;
    }

    @Override
    public Admin getAdminByEmail(String email) {
        Admin admin = null;
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.or();
        criteria.andEmailEqualTo(email);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList.size() > 0){
            admin = adminList.get(0);
        }
        return admin;
    }

    @Override
    public List<Admin> getAdmins() {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.or();
        criteria.andRecoveryIsNull();
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        for(int i=0; i<adminList.size(); i++){
            adminList.get(i).setHeaderurl(GlobalConstants.bgFileUploadUrl+adminList.get(i).getHeaderurl());
        }
        return adminList;
    }

    @Override
    public Integer updataAdminOfprohibitLoginTime(Integer adminId, Integer targetId,Date newProhibitLoginTime) {
        Integer state = 0;
        if(targetId.equals(adminId)){
            state = -1;
        }else if(super.isAuthorize(2,adminId)){
            Admin newAdmin = adminMapper.selectByPrimaryKey(targetId);
            newAdmin.setProhibitlogintime(newProhibitLoginTime);
            state = adminMapper.updateByPrimaryKey(newAdmin);
        }
        return state;
    }

    @Override
    public Integer updataAdminOfNickname(Integer adminId, Integer targetId, String newNickname) {
        Integer state = 0;
        if(super.isAuthorize(2,adminId)){
            Admin newAdmin = adminMapper.selectByPrimaryKey(targetId);
            if(newAdmin != null) {
                newAdmin.setNickname(newNickname);
                state = adminMapper.updateByPrimaryKey(newAdmin);
            }else{
                state = -1;
            }
        }else{
            state = 2;
        }
        return state;
    }

    @Override
    public Integer updataAdminOfEmail(Integer adminId, Integer targetId, String newEmail) {
        Integer state = 0;
        if(super.isAuthorize(2,adminId)){
            Admin newAdmin = adminMapper.selectByPrimaryKey(targetId);
            if(newAdmin != null) {
                newAdmin.setEmail(newEmail);
                state = adminMapper.updateByPrimaryKey(newAdmin);
            }else{
                state = -1;
            }
        }else{
            state = 2;
        }
        return state;
    }

    @Override
    public Integer deleteAdminByAdminId(Integer targetId, Integer adminId) {
        // 最后状态码
        Integer state = 0;
        if(targetId!=null && adminId!=null ){
            if(!targetId.equals(adminId)){
                if(super.isAuthorize(1,adminId)){
                    // 执行删除请求（放入回收站）
                    Admin newAdmin = adminMapper.selectByPrimaryKey(targetId);
                    if(newAdmin!=null) {
                        newAdmin.setRecovery((byte) 1);
                        adminMapper.updateByPrimaryKey(newAdmin);
                        // 强制使其下线
                        Jedis jedis = JedisUtil.getJedis();
                        jedis.del("admin_"+newAdmin.getId());
                        state = 1;
                    }else{
                        // 管理员id不存在
                        state = 4;
                    }
                }else{
                    // 没有权限进行删除
                    state = 2;
                }
            }else{
                // 不能删除自己
                state = 3;
            }

        }else{
            // 传入非法值
            state = 0;
        }
        return state;
    }

}
