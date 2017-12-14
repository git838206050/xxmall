package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.SalesPropertyKey;
import cn.lcy.xxmall.pojo.SalesPropertyKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesPropertyKeyMapper {
    long countByExample(SalesPropertyKeyExample example);

    int deleteByExample(SalesPropertyKeyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SalesPropertyKey record);

    int insertSelective(SalesPropertyKey record);

    List<SalesPropertyKey> selectByExample(SalesPropertyKeyExample example);

    SalesPropertyKey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SalesPropertyKey record, @Param("example") SalesPropertyKeyExample example);

    int updateByExample(@Param("record") SalesPropertyKey record, @Param("example") SalesPropertyKeyExample example);

    int updateByPrimaryKeySelective(SalesPropertyKey record);

    int updateByPrimaryKey(SalesPropertyKey record);
}