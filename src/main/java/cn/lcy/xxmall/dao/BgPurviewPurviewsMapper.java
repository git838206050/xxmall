package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.BgPurviewPurviews;
import cn.lcy.xxmall.pojo.BgPurviewPurviewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BgPurviewPurviewsMapper {
    long countByExample(BgPurviewPurviewsExample example);

    int deleteByExample(BgPurviewPurviewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BgPurviewPurviews record);

    int insertSelective(BgPurviewPurviews record);

    List<BgPurviewPurviews> selectByExample(BgPurviewPurviewsExample example);

    BgPurviewPurviews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BgPurviewPurviews record, @Param("example") BgPurviewPurviewsExample example);

    int updateByExample(@Param("record") BgPurviewPurviews record, @Param("example") BgPurviewPurviewsExample example);

    int updateByPrimaryKeySelective(BgPurviewPurviews record);

    int updateByPrimaryKey(BgPurviewPurviews record);
}