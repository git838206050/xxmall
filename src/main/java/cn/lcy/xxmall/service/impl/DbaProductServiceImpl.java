package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.DbaProductMapper;
import cn.lcy.xxmall.exception.MyDaoException;
import cn.lcy.xxmall.pojo.DbaProduct;
import cn.lcy.xxmall.pojo.DbaProductExample;
import cn.lcy.xxmall.pojo.Product;
import cn.lcy.xxmall.service.DbaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LCY
 * @Date 2017/12/6 14:40
 */
@Service
public class DbaProductServiceImpl implements DbaProductService {
    @Autowired
    private DbaProductMapper dbaProductMapper;

    @Override
    public int insertDbaProduct(String keyword, int productId) {
        int state = 0;
        DbaProduct dbaProduct = new DbaProduct();
        dbaProduct.setKeyword(keyword);
        dbaProduct.setProdictid(productId);
        dbaProduct.setPriority((byte)50);
        state = dbaProductMapper.insert(dbaProduct);
        dbaProduct = null;
        return state;
    }

    @Override
    @Transactional(rollbackFor=MyDaoException.class)
    public int insertDbaProducts(String[] keywords, int productId) throws MyDaoException {
        int state = 0;
        DbaProduct dbaProduct = new DbaProduct();
        for(int i=0; i<keywords.length; i++){
            if(keywords[i].equals("") || keywords[i].equals(null)){
                state = 1;
            }
        }

        if(state == 0){
            for(int i=0; i<keywords.length; i++){
                dbaProduct.setKeyword(keywords[i]);
                dbaProduct.setProdictid(productId);
                dbaProduct.setPriority((byte)50);
                if(dbaProductMapper.insert(dbaProduct) == 0){
                    state = 0;
                    throw new MyDaoException();
                }
            }
        }

        return state;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public int insertDbaProducts(String keywords, int productId) throws Exception {
        int state = 0;
            String[] keywordArr = keywords.split(",");

            DbaProduct dbaProduct = new DbaProduct();
            for(int i=0; i<keywordArr.length; i++){
                if(keywordArr[i].equals("") || keywordArr[i].equals(null)){
                    state = 1;
                }
            }
            if (state == 0) {
                for (int i = 0; i < keywordArr.length; i++) {
                    dbaProduct.setKeyword(keywordArr[i]);
                    dbaProduct.setProdictid(productId);
                    dbaProduct.setPriority((byte) 50);
                    state = dbaProductMapper.insert(dbaProduct);
                }
            }
        return state;
    }

    @Override
    public List<DbaProduct> getDbaProduct(String keyword) {
        DbaProductExample dbaProductExample = new DbaProductExample();
        DbaProductExample.Criteria criteria = dbaProductExample.or();
        criteria.andKeywordEqualTo(keyword);

        return dbaProductMapper.selectByExample(dbaProductExample);
    }

    @Override
    public List<DbaProduct> getDbaProducts(String[] keywords) {
        DbaProductExample dbaProductExample;
        List<DbaProduct> dbaProductList = new ArrayList<DbaProduct>();
        for(int i=0; i<keywords.length; i++){
            dbaProductExample = new DbaProductExample();
            DbaProductExample.Criteria criteria = dbaProductExample.or();
            criteria.andKeywordEqualTo(keywords[i]);
            dbaProductList.addAll( dbaProductMapper.selectByExample(dbaProductExample) );
        }

        return dbaProductList;
    }
}
