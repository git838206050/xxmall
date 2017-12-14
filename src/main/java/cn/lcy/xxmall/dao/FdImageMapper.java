package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.FdImage;
import cn.lcy.xxmall.pojo.FdImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FdImageMapper {
    long countByExample(FdImageExample example);

    int deleteByExample(FdImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FdImage record);

    int insertSelective(FdImage record);

    List<FdImage> selectByExample(FdImageExample example);

    FdImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FdImage record, @Param("example") FdImageExample example);

    int updateByExample(@Param("record") FdImage record, @Param("example") FdImageExample example);

    int updateByPrimaryKeySelective(FdImage record);

    int updateByPrimaryKey(FdImage record);
}