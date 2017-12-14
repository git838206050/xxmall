package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.BgPurviewtype;
import cn.lcy.xxmall.pojo.BgPurviewtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BgPurviewtypeMapper {
    long countByExample(BgPurviewtypeExample example);

    int deleteByExample(BgPurviewtypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BgPurviewtype record);

    int insertSelective(BgPurviewtype record);

    List<BgPurviewtype> selectByExample(BgPurviewtypeExample example);

    BgPurviewtype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BgPurviewtype record, @Param("example") BgPurviewtypeExample example);

    int updateByExample(@Param("record") BgPurviewtype record, @Param("example") BgPurviewtypeExample example);

    int updateByPrimaryKeySelective(BgPurviewtype record);

    int updateByPrimaryKey(BgPurviewtype record);
}