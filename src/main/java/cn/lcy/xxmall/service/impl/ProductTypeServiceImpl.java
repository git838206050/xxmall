package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.ProductTypeMapper;
import cn.lcy.xxmall.pojo.ProductType;
import cn.lcy.xxmall.pojo.ProductTypeExample;
import cn.lcy.xxmall.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/27 23:04
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getProductTypes() {
        ProductTypeExample productTypeExample = new ProductTypeExample();
        ProductTypeExample.Criteria criteria = productTypeExample.or();
        criteria.andIdIsNotNull();
        return productTypeMapper.selectByExample(productTypeExample);
    }

    @Override
    public ProductType getProductTypeById(int id) {
        ProductTypeExample productTypeExample = new ProductTypeExample();
        ProductTypeExample.Criteria criteria = productTypeExample.or();
        criteria.andIdEqualTo(id);
        List<ProductType> productTypeList = productTypeMapper.selectByExample(productTypeExample);
        ProductType productType = null;
        if(productTypeList.size() > 0){
            productType = productTypeList.get(0);
        }
        return productType;
    }

    @Override
    public List<ProductType> getProductTypesByParent(String parent) {
        ProductTypeExample productTypeExample = new ProductTypeExample();
        ProductTypeExample.Criteria criteria = productTypeExample.or();
        criteria.andParentEqualTo(parent);
        List<ProductType> productTypeList = productTypeMapper.selectByExample(productTypeExample);
        return productTypeList;
    }
}
