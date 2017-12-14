package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.ProductTypePropertyMapper;
import cn.lcy.xxmall.pojo.ProductTypeProperty;
import cn.lcy.xxmall.pojo.ProductTypePropertyExample;
import cn.lcy.xxmall.service.ProductTypePropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/27 23:31
 */
@Service
public class ProductTypePropertyServiceImpl implements ProductTypePropertyService {
    @Autowired
    private ProductTypePropertyMapper productTypePropertyMapper;
    @Override
    public List<ProductTypeProperty> getProductTypePropertysByProductTypeId(int productTypeId) {
        ProductTypePropertyExample productTypePropertyExample = new ProductTypePropertyExample();
        ProductTypePropertyExample.Criteria criteria = productTypePropertyExample.or();
        criteria.andProducttypeidEqualTo(productTypeId);
        List<ProductTypeProperty> productTypePropertyList = productTypePropertyMapper.selectByExample(productTypePropertyExample);
        return productTypePropertyList;
    }
}
