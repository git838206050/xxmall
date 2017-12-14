package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.BgPurviews;
import cn.lcy.xxmall.pojo.BgPurviewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BgPurviewsMapper {
    long countByExample(BgPurviewsExample example);

    int deleteByExample(BgPurviewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BgPurviews record);

    int insertSelective(BgPurviews record);

    List<BgPurviews> selectByExample(BgPurviewsExample example);

    BgPurviews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BgPurviews record, @Param("example") BgPurviewsExample example);

    int updateByExample(@Param("record") BgPurviews record, @Param("example") BgPurviewsExample example);

    int updateByPrimaryKeySelective(BgPurviews record);

    int updateByPrimaryKey(BgPurviews record);
}