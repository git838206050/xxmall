package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.BgRolePurview;
import cn.lcy.xxmall.pojo.BgRolePurviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BgRolePurviewMapper {
    long countByExample(BgRolePurviewExample example);

    int deleteByExample(BgRolePurviewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BgRolePurview record);

    int insertSelective(BgRolePurview record);

    List<BgRolePurview> selectByExample(BgRolePurviewExample example);

    BgRolePurview selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BgRolePurview record, @Param("example") BgRolePurviewExample example);

    int updateByExample(@Param("record") BgRolePurview record, @Param("example") BgRolePurviewExample example);

    int updateByPrimaryKeySelective(BgRolePurview record);

    int updateByPrimaryKey(BgRolePurview record);
}