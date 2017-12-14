package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.BgImage;
import cn.lcy.xxmall.pojo.BgImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BgImageMapper {
    long countByExample(BgImageExample example);

    int deleteByExample(BgImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BgImage record);

    int insertSelective(BgImage record);

    List<BgImage> selectByExample(BgImageExample example);

    BgImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BgImage record, @Param("example") BgImageExample example);

    int updateByExample(@Param("record") BgImage record, @Param("example") BgImageExample example);

    int updateByPrimaryKeySelective(BgImage record);

    int updateByPrimaryKey(BgImage record);
}