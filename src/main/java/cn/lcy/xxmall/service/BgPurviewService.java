package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.BgPurview;

import java.util.List;

/**
 * 权限业务接口
 * 权限数据表只提供获取数据，不能添加和修改。（要修改只能手动到数据库内修改）
 * @Author LCY
 * @Date 2017/11/3 9:50
 */
public interface BgPurviewService {
    /**
     * 获取所有权限
     * @return
     */
    List<BgPurview> getBgPurviews();

    /**
     * 根据权限类型获取指定权限集合
     * @param purviewTypeId 权限类型，对应数据库权限类型表的id
     * @return
     */
    List<BgPurview> getBgPurviewsByPurviewType(Integer purviewTypeId);

    /**
     * 根据动作名称获取指定权限集合
     * @param action
     * @return
     */
    List<BgPurview> getBgPurviewsByAction(String action);
}
