package cn.lcy.xxmall.dao;

import cn.lcy.xxmall.pojo.ProductTypeProperty;
import cn.lcy.xxmall.pojo.ProductTypePropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductTypePropertyMapper {
    long countByExample(ProductTypePropertyExample example);

    int deleteByExample(ProductTypePropertyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductTypeProperty record);

    int insertSelective(ProductTypeProperty record);

    List<ProductTypeProperty> selectByExample(ProductTypePropertyExample example);

    ProductTypeProperty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductTypeProperty record, @Param("example") ProductTypePropertyExample example);

    int updateByExample(@Param("record") ProductTypeProperty record, @Param("example") ProductTypePropertyExample example);

    int updateByPrimaryKeySelective(ProductTypeProperty record);

    int updateByPrimaryKey(ProductTypeProperty record);
}