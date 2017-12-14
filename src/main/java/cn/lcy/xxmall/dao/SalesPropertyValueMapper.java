package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.SalesPropertyValue;
import cn.lcy.xxmall.pojo.SalesPropertyValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesPropertyValueMapper {
    long countByExample(SalesPropertyValueExample example);

    int deleteByExample(SalesPropertyValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SalesPropertyValue record);

    int insertSelective(SalesPropertyValue record);

    List<SalesPropertyValue> selectByExample(SalesPropertyValueExample example);

    SalesPropertyValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SalesPropertyValue record, @Param("example") SalesPropertyValueExample example);

    int updateByExample(@Param("record") SalesPropertyValue record, @Param("example") SalesPropertyValueExample example);

    int updateByPrimaryKeySelective(SalesPropertyValue record);

    int updateByPrimaryKey(SalesPropertyValue record);
}