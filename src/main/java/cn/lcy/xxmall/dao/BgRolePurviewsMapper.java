package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.BgRolePurviews;
import cn.lcy.xxmall.pojo.BgRolePurviewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BgRolePurviewsMapper {
    long countByExample(BgRolePurviewsExample example);

    int deleteByExample(BgRolePurviewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BgRolePurviews record);

    int insertSelective(BgRolePurviews record);

    List<BgRolePurviews> selectByExample(BgRolePurviewsExample example);

    BgRolePurviews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BgRolePurviews record, @Param("example") BgRolePurviewsExample example);

    int updateByExample(@Param("record") BgRolePurviews record, @Param("example") BgRolePurviewsExample example);

    int updateByPrimaryKeySelective(BgRolePurviews record);

    int updateByPrimaryKey(BgRolePurviews record);
}