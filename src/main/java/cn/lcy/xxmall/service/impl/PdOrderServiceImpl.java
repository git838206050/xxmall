package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.PdOrderMapper;
import cn.lcy.xxmall.dao.ProductMapper;
import cn.lcy.xxmall.dao.ShopMapper;
import cn.lcy.xxmall.pojo.*;
import cn.lcy.xxmall.service.PdOrderService;
import cn.lcy.xxmall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author LCY
 * @Date 2017/12/22 21:18
 */
@Service
public class PdOrderServiceImpl implements PdOrderService{
    @Autowired
    private PdOrderMapper pdOrderMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public int insertPdOrder(int productId, int userId, BigDecimal price, String deliverAddress ) {
        int state = 0;
        try {
            Product product = productMapper.selectByPrimaryKey(productId);
            Shop shop = shopMapper.selectByPrimaryKey(product.getShopid());

            PdOrder pdOrder = new PdOrder();
            pdOrder.setProductid(productId);
            pdOrder.setUserid(userId);
            pdOrder.setPrice(price);
            pdOrder.setDeliveraddress(deliverAddress);
            pdOrder.setSendaddress(shop.getAddress());
            pdOrder.setCreatetime(DateUtil.getDate());
            pdOrder.setIsclosed((byte)0);
            pdOrder.setOrderstatus((byte)0);

            state = pdOrderMapper.insert(pdOrder);
        }catch (Exception e){
            state = 0;
        }finally {
            return state;
        }
    }

    @Override
    public List<PdOrder> getPdOrders() {
        PdOrderExample pdOrderExample = new PdOrderExample();
        PdOrderExample.Criteria pdOrderCriteria = pdOrderExample.or();
        pdOrderCriteria.andIdIsNotNull();
        return pdOrderMapper.selectByExample(pdOrderExample);
    }

    @Override
    public List<PdOrder> getPdOrders(int userId) {
        PdOrderExample pdOrderExample = new PdOrderExample();
        PdOrderExample.Criteria pdOrderCriteria = pdOrderExample.or();
        pdOrderCriteria.andIdEqualTo(userId);
        return pdOrderMapper.selectByExample(pdOrderExample);
    }

    @Override
    public List<PdOrder> getPdOrdersOfCreateTime(String createTime) {
        return null;
    }

    @Override
    public List<PdOrder> getPdOrdersOfExpressNo(String expressNo) {
        PdOrderExample pdOrderExample = new PdOrderExample();
        PdOrderExample.Criteria pdOrderCriteria = pdOrderExample.or();
        pdOrderCriteria.andExpressnoEqualTo(expressNo);
        return pdOrderMapper.selectByExample(pdOrderExample);
    }

    @Override
    public int updataPdOrder(PdOrder pdOrder) {
        int state = 0;
        try {
            PdOrder oPdOrder = pdOrderMapper.selectByPrimaryKey(pdOrder.getId());
            if(pdOrder.getPrice()!=null){
                oPdOrder.setPrice(pdOrder.getPrice());
            }
            if(pdOrder.getDeliveraddress()!=null){
                oPdOrder.setDeliveraddress(pdOrder.getDeliveraddress());
            }
            if(pdOrder.getExpressno()!=null){
                oPdOrder.setExpressno(pdOrder.getExpressno());
            }
            if(pdOrder.getExpressname()!=null){
                oPdOrder.setExpressname(pdOrder.getExpressname());
            }
            state = pdOrderMapper.updateByPrimaryKey(oPdOrder);
        }catch (Exception e){
            state = 0;
        }finally {
            return state;
        }
    }

    @Override
    public int updataPdOrderOfExpressNo(int orderId, String expressNo) {
        PdOrder pdOrder = pdOrderMapper.selectByPrimaryKey(orderId);
        pdOrder.setExpressno(expressNo);
        return pdOrderMapper.updateByPrimaryKey(pdOrder);
    }

    @Override
    public int updataPdOrderOfIsClosed(int orderId, String isClosed) {
        int state = 0;
        try {
            PdOrder pdOrder = pdOrderMapper.selectByPrimaryKey(orderId);
            pdOrder.setIsclosed(Byte.valueOf(isClosed));
            state = pdOrderMapper.updateByPrimaryKey(pdOrder);
        }catch (Exception e){
            state = 0;
        }
        return state;
    }

    @Override
    public int updataPdOrderOfExpressName(int orderId, String expressName) {
        PdOrder pdOrder = pdOrderMapper.selectByPrimaryKey(orderId);
        pdOrder.setExpressname(expressName);
        return pdOrderMapper.updateByPrimaryKey(pdOrder);
    }

    @Override
    public int updataPdOrderOfDeliverAddress(int orderId, String deliverAddress) {
        PdOrder pdOrder = pdOrderMapper.selectByPrimaryKey(orderId);
        pdOrder.setDeliveraddress(deliverAddress);
        return pdOrderMapper.updateByPrimaryKey(pdOrder);
    }

    @Override
    public int updataPdOrderOfOrderStatus(int orderId, String orderStatus) {
        int state = 0;
        try {
            Byte ByteOrderStatus = Byte.valueOf(orderStatus);
            if(ByteOrderStatus<0 || ByteOrderStatus>5){
                throw new NullPointerException();
            }
            PdOrder pdOrder = pdOrderMapper.selectByPrimaryKey(orderId);
            pdOrder.setOrderstatus(Byte.valueOf(orderStatus));
            state = pdOrderMapper.updateByPrimaryKey(pdOrder);
        }catch (Exception e){
            state = 0;
        }finally {
            return state;
        }
    }

}
