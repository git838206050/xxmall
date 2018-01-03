package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.UserDetailedInfo;
import cn.lcy.xxmall.pojo.UserDetailedInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDetailedInfoMapper {
    long countByExample(UserDetailedInfoExample example);

    int deleteByExample(UserDetailedInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDetailedInfo record);

    int insertSelective(UserDetailedInfo record);

    List<UserDetailedInfo> selectByExample(UserDetailedInfoExample example);

    UserDetailedInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDetailedInfo record, @Param("example") UserDetailedInfoExample example);

    int updateByExample(@Param("record") UserDetailedInfo record, @Param("example") UserDetailedInfoExample example);

    int updateByPrimaryKeySelective(UserDetailedInfo record);

    int updateByPrimaryKey(UserDetailedInfo record);
}