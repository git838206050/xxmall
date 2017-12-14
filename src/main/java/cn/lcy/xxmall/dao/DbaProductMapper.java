package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.DbaProduct;
import cn.lcy.xxmall.pojo.DbaProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbaProductMapper {
    long countByExample(DbaProductExample example);

    int deleteByExample(DbaProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DbaProduct record);

    int insertSelective(DbaProduct record);

    List<DbaProduct> selectByExample(DbaProductExample example);

    DbaProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DbaProduct record, @Param("example") DbaProductExample example);

    int updateByExample(@Param("record") DbaProduct record, @Param("example") DbaProductExample example);

    int updateByPrimaryKeySelective(DbaProduct record);

    int updateByPrimaryKey(DbaProduct record);
}