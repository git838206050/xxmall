package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.BgRoleAdminMapper;
import cn.lcy.xxmall.dao.BgRolePurviewMapper;
import cn.lcy.xxmall.pojo.BgRoleAdmin;
import cn.lcy.xxmall.pojo.BgRoleAdminExample;
import cn.lcy.xxmall.pojo.BgRolePurview;
import cn.lcy.xxmall.pojo.BgRolePurviewExample;
import cn.lcy.xxmall.service.BgRolePurviewAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/3 11:24
 */
@Service
public class BgRolePurviewAdminServiceImpl implements BgRolePurviewAdminService{
    @Autowired
    private BgRolePurviewMapper bgRolePurviewMapper;
    @Autowired
    private BgRoleAdminMapper bgRoleAdminMapper;
//    @Override
//    public Boolean isAuthorize(Integer purviewId, Integer adminId) {
//        // 最后是否授权结果
//        Boolean state = false;
//
//        // 获取权限授权角色
//        BgRolePurviewExample bgRolePurviewExample = new BgRolePurviewExample();
//        BgRolePurviewExample.Criteria bgRolePurviewCriteria = bgRolePurviewExample.or();
//        bgRolePurviewCriteria.andBgpurviewidEqualTo(purviewId);
//        List<BgRolePurview> bgRolePurviewList =  bgRolePurviewMapper.selectByExample(bgRolePurviewExample);
//
//        // 获取管理员角色
//        BgRoleAdminExample bgRoleAdminExample = new BgRoleAdminExample();
//        BgRoleAdminExample.Criteria bgRoleAdminCriteria = bgRoleAdminExample.or();
//        bgRoleAdminCriteria.andAdminidEqualTo(adminId);
//        List<BgRoleAdmin> bgRoleAdminList = bgRoleAdminMapper.selectByExample(bgRoleAdminExample);
//
//        // 匹配管理员角色与权限授权角色是否一致
//        if(bgRoleAdminList.size() == 1 && bgRolePurviewList.size()>0){
//            for(int i=0; i<bgRolePurviewList.size(); i++){
//                if(bgRoleAdminList.get(0).getBgroleid().equals( bgRolePurviewList.get(i).getBgroleid() )){
//                    state = true;
//                    break;
//                }
//            }
//        }
//        return state;
//    }
}
