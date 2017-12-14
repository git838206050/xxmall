package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.BgRole;
import cn.lcy.xxmall.pojo.BgRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BgRoleMapper {
    long countByExample(BgRoleExample example);

    int deleteByExample(BgRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BgRole record);

    int insertSelective(BgRole record);

    List<BgRole> selectByExample(BgRoleExample example);

    BgRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BgRole record, @Param("example") BgRoleExample example);

    int updateByExample(@Param("record") BgRole record, @Param("example") BgRoleExample example);

    int updateByPrimaryKeySelective(BgRole record);

    int updateByPrimaryKey(BgRole record);
}