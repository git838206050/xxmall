package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.BgPurview;
import cn.lcy.xxmall.pojo.BgPurviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BgPurviewMapper {
    long countByExample(BgPurviewExample example);

    int deleteByExample(BgPurviewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BgPurview record);

    int insertSelective(BgPurview record);

    List<BgPurview> selectByExample(BgPurviewExample example);

    BgPurview selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BgPurview record, @Param("example") BgPurviewExample example);

    int updateByExample(@Param("record") BgPurview record, @Param("example") BgPurviewExample example);

    int updateByPrimaryKeySelective(BgPurview record);

    int updateByPrimaryKey(BgPurview record);
}