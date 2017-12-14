package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.PageMessage;
import cn.lcy.xxmall.pojo.PageMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageMessageMapper {
    long countByExample(PageMessageExample example);

    int deleteByExample(PageMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageMessage record);

    int insertSelective(PageMessage record);

    List<PageMessage> selectByExample(PageMessageExample example);

    PageMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageMessage record, @Param("example") PageMessageExample example);

    int updateByExample(@Param("record") PageMessage record, @Param("example") PageMessageExample example);

    int updateByPrimaryKeySelective(PageMessage record);

    int updateByPrimaryKey(PageMessage record);
}