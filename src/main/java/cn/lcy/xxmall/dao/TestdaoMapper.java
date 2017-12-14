package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.Testdao;
import cn.lcy.xxmall.pojo.TestdaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestdaoMapper {
    long countByExample(TestdaoExample example);

    int deleteByExample(TestdaoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Testdao record);

    int insertSelective(Testdao record);

    List<Testdao> selectByExample(TestdaoExample example);

    Testdao selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Testdao record, @Param("example") TestdaoExample example);

    int updateByExample(@Param("record") Testdao record, @Param("example") TestdaoExample example);

    int updateByPrimaryKeySelective(Testdao record);

    int updateByPrimaryKey(Testdao record);
}