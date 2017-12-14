package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.SalesPropertyKeyMapper;
import cn.lcy.xxmall.pojo.SalesPropertyKey;
import cn.lcy.xxmall.pojo.SalesPropertyKeyExample;
import cn.lcy.xxmall.service.SalesPropertyKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性
 * @Author LCY
 * @Date 2017/11/28 0:16
 */
@Service
public class SalesPropertyKeyServiceImpl implements SalesPropertyKeyService {
    @Autowired
    private SalesPropertyKeyMapper salesPropertyKeyMapper;

    @Override
    public List<SalesPropertyKey> getSalesPropertyKeys() {
        SalesPropertyKeyExample salesPropertyKeyExample = new SalesPropertyKeyExample();
        SalesPropertyKeyExample.Criteria criteria = salesPropertyKeyExample.or();
        criteria.andIdIsNotNull();
        return salesPropertyKeyMapper.selectByExample(salesPropertyKeyExample);
    }

    @Override
    public SalesPropertyKey getSalesPropertyKeyBySalesPropertyKeyId(int salesPropertyKeyId) {
        SalesPropertyKey salesPropertyKey = null;
        SalesPropertyKeyExample salesPropertyKeyExample = new SalesPropertyKeyExample();
        SalesPropertyKeyExample.Criteria criteria = salesPropertyKeyExample.or();
        criteria.andIdIsNotNull();
        List<SalesPropertyKey> salesPropertyKeyList = salesPropertyKeyMapper.selectByExample(salesPropertyKeyExample);
        if(salesPropertyKeyList.size() > 0){
            salesPropertyKey = salesPropertyKeyList.get(0);
        }
        return salesPropertyKey;
    }
}
