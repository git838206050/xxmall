package cn.lcy.xxmall.service.common;

import cn.lcy.xxmall.dao.BgPurviewPurviewsMapper;
import cn.lcy.xxmall.dao.BgRoleAdminMapper;
import cn.lcy.xxmall.dao.BgRolePurviewsMapper;
import cn.lcy.xxmall.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/3 15:02
 */
@Service
public class BaseService {
    @Autowired
    private BgPurviewPurviewsMapper bgPurviewPurviewsMapper;
    @Autowired
    private BgRolePurviewsMapper bgRolePurviewsMapper;
    @Autowired
    private BgRoleAdminMapper bgRoleAdminMapper;

    /**
     * 判断是否授权
     * @param purviewId 权限id，根据数据库权限表的id所提供
     * @param adminId 需要判断是否授权的管理员id
     * @return ture：授权
     */
    public Boolean isAuthorize(Integer purviewId, Integer adminId) {
        if(adminId == null || purviewId == null || adminId<1 || purviewId<1){
            return false;
        }

        // 最后是否授权结果
        Boolean state = false;

        // 获取所属权限组 (单位可能为多个)
        BgPurviewPurviewsExample bgPurviewPurviewsExample = new BgPurviewPurviewsExample();
        BgPurviewPurviewsExample.Criteria bgPurviewPurviewsCriteria = bgPurviewPurviewsExample.or();
        bgPurviewPurviewsCriteria.andBgpurviewidEqualTo(purviewId);
        List<BgPurviewPurviews> bgPurviewPurviewsList = bgPurviewPurviewsMapper.selectByExample(bgPurviewPurviewsExample);

        // 获取所属权限组 授权角色 (单位可能为多个)
        BgRolePurviewsExample bgRolePurviewsExample = new BgRolePurviewsExample();
        BgRolePurviewsExample.Criteria bgRolePurviewsCriteria = bgRolePurviewsExample.or();
        List<Integer> purviewsIdList = new ArrayList<Integer>();
        for(int i=0; i<bgPurviewPurviewsList.size(); i++){
            purviewsIdList.add(bgPurviewPurviewsList.get(i).getBgpurviewsid());
        }
        bgRolePurviewsCriteria.andBgpurviewsidIn(purviewsIdList);
        List<BgRolePurviews> bgRolePurviewsList = bgRolePurviewsMapper.selectByExample(bgRolePurviewsExample);

        // 获取管理员角色
        BgRoleAdminExample bgRoleAdminExample = new BgRoleAdminExample();
        BgRoleAdminExample.Criteria bgRoleAdminCriteria = bgRoleAdminExample.or();
        bgRoleAdminCriteria.andAdminidEqualTo(adminId);
        List<BgRoleAdmin> bgRoleAdminList = bgRoleAdminMapper.selectByExample(bgRoleAdminExample);

        // 匹配管理员角色与权限授权角色是否一致
        if (bgRoleAdminList.size() == 1 && bgRolePurviewsList.size() > 0) {
            for (int i = 0; i < bgRolePurviewsList.size(); i++) {
                if (bgRoleAdminList.get(0).getBgroleid().equals(bgRolePurviewsList.get(i).getBgroleid())) {
                    state = true;
                    break;
                }
            }
        }
        return state;
    }

    /**
     * 验证两个id是否为非法值，或是否一致
     * @param targetId
     * @param adminId
     * @return
     */
    public Boolean verificationId(Integer targetId, Integer adminId){
        Boolean state = false;
        if(targetId!=null && adminId!=null && !targetId.equals(adminId)){
            state = true;
        }
        return state;
    }
}
