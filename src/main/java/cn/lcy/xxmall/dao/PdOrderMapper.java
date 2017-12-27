package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.PdOrder;
import cn.lcy.xxmall.pojo.PdOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PdOrderMapper {
    long countByExample(PdOrderExample example);

    int deleteByExample(PdOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PdOrder record);

    int insertSelective(PdOrder record);

    List<PdOrder> selectByExample(PdOrderExample example);

    PdOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PdOrder record, @Param("example") PdOrderExample example);

    int updateByExample(@Param("record") PdOrder record, @Param("example") PdOrderExample example);

    int updateByPrimaryKeySelective(PdOrder record);

    int updateByPrimaryKey(PdOrder record);
}