package cn.lcy.xxmall.service;

import cn.lcy.xxmall.exception.MyAdminPurviewException;
import cn.lcy.xxmall.exception.MyFormPropertyException;
import cn.lcy.xxmall.pojo.Shop;

import java.util.List;

/**
 * 店铺业务
 * @Author LCY
 * @Date 2017/11/17 12:46
 */
public interface ShopService {
    /**
     * 执行添加店铺请求
     * 该功能用户也可以执行，而且不是直接进行添加，还需管理员审核后才能完成真正的添加店铺功能
     * @param username 添加店铺的用户名
     * @param shopName  店铺名
     * @param adminId 执行该动作的管理员id
     * @param address 店铺地址
     * @param decorateContent 店铺装修内容
     * @return -1：添加失败，用户不存在；1：添加成功；
     */
    int insertShop(String username, Integer adminId, String shopName, String address, String decorateContent) throws MyFormPropertyException,MyAdminPurviewException;

    /**
     * 根据用户id获取指定店铺的信息
     * @param targetId
     * @return
     */
    Shop getShopByUserId(Integer targetId);

    /**
     * 获取所有审核通过的店铺信息
     * @return
     */
    List<Shop> getShopsOfState1();

    /**
     * 获取所有待审核的店铺信息
     * @return
     */
    List<Shop> getShopsOfState0();


    /**
     * 将指定店铺放至回收站中
     * @param targetId 店铺的用户ID
     * @param adminId 执行该操作的管理员ID
     * @return
     */
    int deleteShopByUserId(Integer targetId, Integer adminId);

    /**
     * 根据标识编辑指定店铺
     * @param targetId 店铺的用户ID
     * @param adminId 执行该操作的管理员ID
     * @return
     */
//    int updateShopByUserId(Integer targetId, Integer adminId);

    /**
     * 根据标识编辑指定店铺
     * @param userId 用户名ID
     * @return
     */
    Shop getShopByUserId(int userId);

    /**
     * 根据标识编辑指定店铺
     * @param shopName 用户名ID
     * @return
     */
    Shop getShopByShopName(String shopName);
}
