package cn.lcy.xxmall.test.service;

import cn.lcy.xxmall.dao.ShopMapper;
import cn.lcy.xxmall.pojo.Shop;
import cn.lcy.xxmall.test.base.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author LCY
 * @Date 2017/11/23 21:36
 */
public class ShopServiceTest extends SpringJunitTest {
    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void testShopService(){
        Shop shop = new Shop();
        for(int i=1012; i<1999;i++){
            shop.setState((byte)1);
            shop.setAddress("广西/柳州/鱼峰/天马街道/天马街道");
            shop.setLevel(0);
            shop.setName("shopName_"+String.valueOf(i));
            shop.setUserid(i);
            shopMapper.insert(shop);
        }
    }
}
