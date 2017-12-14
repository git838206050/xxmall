package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.ProductMapper;
import cn.lcy.xxmall.dao.ProductSkuMapper;
import cn.lcy.xxmall.pojo.ProductSku;
import cn.lcy.xxmall.pojo.ProductSkuExample;
import cn.lcy.xxmall.service.ProductSkuService;
import cn.lcy.xxmall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author LCY
 * @Date 2017/12/14 11:50
 */
@Service
public class ProductSkuServiceImpl implements ProductSkuService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public int insertProductSku(int productId, String propertykey, String propertyvaluegroup) {
        int state = 0;
        ProductSku productSku = new ProductSku();
        try {
            productSku.setProductid(productId);
            productSku.setPropertykey(propertykey);
            productSku.setPropertyvaluegroup(propertyvaluegroup);
            productSku.setCreattime(DateUtil.getDate());
            state = productSkuMapper.insert(productSku);
        }catch (Exception e){
            state = 0;
        }finally {
            return state;
        }
    }

    @Override
    public ProductSku getProductSkuByProductId(int productId) {
        ProductSkuExample productSkuExample = new ProductSkuExample();
        ProductSkuExample.Criteria criteria = productSkuExample.or();
        criteria.andProductidEqualTo(productId);
        return productSkuMapper.selectByExample(productSkuExample).get(0);
    }
}
