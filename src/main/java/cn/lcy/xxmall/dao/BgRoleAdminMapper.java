package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.BgRoleAdmin;
import cn.lcy.xxmall.pojo.BgRoleAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BgRoleAdminMapper {
    long countByExample(BgRoleAdminExample example);

    int deleteByExample(BgRoleAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BgRoleAdmin record);

    int insertSelective(BgRoleAdmin record);

    List<BgRoleAdmin> selectByExample(BgRoleAdminExample example);

    BgRoleAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BgRoleAdmin record, @Param("example") BgRoleAdminExample example);

    int updateByExample(@Param("record") BgRoleAdmin record, @Param("example") BgRoleAdminExample example);

    int updateByPrimaryKeySelective(BgRoleAdmin record);

    int updateByPrimaryKey(BgRoleAdmin record);
}