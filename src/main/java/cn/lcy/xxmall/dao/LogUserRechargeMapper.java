package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.LogUserRecharge;
import cn.lcy.xxmall.pojo.LogUserRechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogUserRechargeMapper {
    long countByExample(LogUserRechargeExample example);

    int deleteByExample(LogUserRechargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogUserRecharge record);

    int insertSelective(LogUserRecharge record);

    List<LogUserRecharge> selectByExample(LogUserRechargeExample example);

    LogUserRecharge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogUserRecharge record, @Param("example") LogUserRechargeExample example);

    int updateByExample(@Param("record") LogUserRecharge record, @Param("example") LogUserRechargeExample example);

    int updateByPrimaryKeySelective(LogUserRecharge record);

    int updateByPrimaryKey(LogUserRecharge record);
}