package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.ProductMapper;
import cn.lcy.xxmall.dao.ProductSkuMapper;
import cn.lcy.xxmall.pojo.ProductSku;
import cn.lcy.xxmall.pojo.ProductSkuExample;
import cn.lcy.xxmall.service.ProductSkuService;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public int insertProductSku(int productId, String propertykey, String propertyvaluegroup, boolean[] imageNum, List<String> productSKUImageFileName) {
        int state = 0;
        ProductSku productSku = new ProductSku();
        try {
            productSku.setProductid(productId);
            productSku.setPropertyvaluegroup(propertyvaluegroup);

            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Object>>() {}.getType();
            propertykey = StrUtil.dislodgeAllTag(propertykey);
            ArrayList<Object> list = gson.fromJson(propertykey, type);
            LinkedTreeMap linkedTreeMap;
            for(int i=0,k=0; i<list.size(); i++){
                if(imageNum[i]){
                    linkedTreeMap = (LinkedTreeMap)list.get(i);
                    Set set = linkedTreeMap.keySet();
                    int j = 0;
                    for (Object str : set) {
                        if(j!=0 && productSKUImageFileName.size()>k){
                            propertykey = propertykey.replace(String.valueOf(i+"_"+j+"_img"),productSKUImageFileName.get(k));
                            k++;
                        }
                        j++;
                    }
                }
            }

            productSku.setPropertykey(propertykey);
            productSku.setCreattime(DateUtil.getDate());
            state = productSkuMapper.insert(productSku);
        }catch (Exception e){
            state = 0;
            e.printStackTrace();
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
