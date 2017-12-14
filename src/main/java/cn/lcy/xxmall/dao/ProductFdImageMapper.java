package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.ProductFdImage;
import cn.lcy.xxmall.pojo.ProductFdImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductFdImageMapper {
    long countByExample(ProductFdImageExample example);

    int deleteByExample(ProductFdImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductFdImage record);

    int insertSelective(ProductFdImage record);

    List<ProductFdImage> selectByExample(ProductFdImageExample example);

    ProductFdImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductFdImage record, @Param("example") ProductFdImageExample example);

    int updateByExample(@Param("record") ProductFdImage record, @Param("example") ProductFdImageExample example);

    int updateByPrimaryKeySelective(ProductFdImage record);

    int updateByPrimaryKey(ProductFdImage record);
}