package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.ProductFdImageMapper;
import cn.lcy.xxmall.pojo.ProductFdImage;
import cn.lcy.xxmall.pojo.ProductFdImageExample;
import cn.lcy.xxmall.service.ProductFdImageService;
import cn.lcy.xxmall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/12/11 14:35
 */
@Service
public class ProductFdImageServiceImpl implements ProductFdImageService {
    @Autowired
    private ProductFdImageMapper productFdImageMapper;

    @Override
    public int insertProductFdImage(int productId, int imageId, Byte imageType, int orderNum) {
        ProductFdImage productFdImage = new ProductFdImage();
        productFdImage.setProductid(productId);
        productFdImage.setImageid(imageId);
        productFdImage.setImagetype(imageType);
        productFdImage.setOrdernum(orderNum);
        productFdImage.setCreattime( DateUtil.getDate() );
        return productFdImageMapper.insert(productFdImage);
    }

    @Override
    public int insertProductFdImages(List<ProductFdImage> productFdImageList) {
        int state = 1;
        try {
            for (int i = 0; i < productFdImageList.size(); i++) {
                if(productFdImageList.get(i).getOrdernum() == null){
                    productFdImageList.get(i).setOrdernum(50);
                }
                productFdImageList.get(i).setCreattime(DateUtil.getDate());
                productFdImageMapper.insert(productFdImageList.get(i));
            }
        }catch (Exception e){
            state = 0;
        }
        return state;
    }

    @Override
    public List<ProductFdImage> getProductFdImagesByProductId(int productId) {
        ProductFdImageExample productFdImageExample = new ProductFdImageExample();
        ProductFdImageExample.Criteria criteria = productFdImageExample.or();
        criteria.andProductidEqualTo(productId);
        productFdImageExample.setOrderByClause("ordernum asc");
        return productFdImageMapper.selectByExample(productFdImageExample);
    }
}
