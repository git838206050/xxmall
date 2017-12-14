package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.ShopMapper;
import cn.lcy.xxmall.dao.UserMapper;
import cn.lcy.xxmall.exception.MyFormPropertyException;
import cn.lcy.xxmall.pojo.Shop;
import cn.lcy.xxmall.pojo.ShopExample;
import cn.lcy.xxmall.pojo.User;
import cn.lcy.xxmall.pojo.UserExample;
import cn.lcy.xxmall.service.ShopService;
import cn.lcy.xxmall.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/17 13:05
 */
@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private UserMapper userMapper;

    private static Shop shop;

    @Override
    public int insertShop(String username, Integer adminId, String shopName, String address, String decorateContent) throws MyFormPropertyException {
        int state = 0;
        // 内容最长度 10亿个字符
        if(username == null || shopName.length()<2 || shopName.length()>20 || address.length()>255 || decorateContent.length()>1000000000) {
            throw new MyFormPropertyException();
        }else{
            UserExample userExample = new UserExample();
            UserExample.Criteria userExampleCriteria = userExample.or();
            userExampleCriteria.andUsernameEqualTo(username);
            List<User> userList = userMapper.selectByExample(userExample);
            if(userList.size() == 1){
                shop = new Shop();
                shop.setUserid(userList.get(0).getId());
                shop.setName(shopName);
                shop.setAddress(StrUtil.dislodgeAllTag(address));
                shop.setDecoratecontent(StrUtil.dislodgeScriptTag(decorateContent));
                shop.setState((byte)0);
                shop.setLevel(0);
                state = shopMapper.insert(shop);
            }else{
                // 用户不存在
                state = -1;
            }
        }
        return state;
    }

    @Override
    public Shop getShopByUserId(Integer targetId) {
        ShopExample shopExample = new ShopExample();
        ShopExample.Criteria shopCriteria = shopExample.or();
        shopCriteria.andUseridEqualTo(targetId);
        List<Shop> shopList = shopMapper.selectByExample(shopExample);
        return shopList.size()>0 ? shopList.get(0):null;
    }

    @Override
    public List<Shop> getShopsOfState1() {
        ShopExample shopExample = new ShopExample();
        ShopExample.Criteria shopCriteria = shopExample.or();
        shopCriteria.andStateEqualTo((byte)1);
        List<Shop> shopList = shopMapper.selectByExample(shopExample);
        return shopList;
    }

    @Override
    public List<Shop> getShopsOfState0() {
        ShopExample shopExample = new ShopExample();
        ShopExample.Criteria shopCriteria = shopExample.or();
        shopCriteria.andStateEqualTo((byte)0);
        List<Shop> shopList = shopMapper.selectByExample(shopExample);
        return shopList;
    }

    @Override
    public int deleteShopByUserId(Integer targetId, Integer adminId) {
        ShopExample shopExample = new ShopExample();
        ShopExample.Criteria shopCriteria = shopExample.or();
        shopCriteria.andUseridEqualTo(targetId);
        List<Shop> shopList = shopMapper.selectByExample(shopExample);
        shop = null;
        if(shopList.size()>0){
            shop = shopList.get(0);
        }
        shop.setState((byte)1);
        return shopMapper.updateByPrimaryKey(shop);
    }

    @Override
    public Shop getShopByUserId(int userId) {
        ShopExample shopExample = new ShopExample();
        ShopExample.Criteria shopCriteria = shopExample.or();
        shopCriteria.andUseridEqualTo(userId);
        List<Shop> shopList = shopMapper.selectByExample(shopExample);
        shop = null;
        if(shopList.size() >0){
            shop = shopList.get(0);
        }
        return shop;
    }

    @Override
    public Shop getShopByShopName(String shopName) {
        ShopExample shopExample = new ShopExample();
        ShopExample.Criteria shopCriteria = shopExample.or();
        shopCriteria.andNameEqualTo(shopName);
        List<Shop> shopList = shopMapper.selectByExample(shopExample);
        shop = null;
        if(shopList.size() >0){
            shop = shopList.get(0);
        }
        return shop;
    }

}
