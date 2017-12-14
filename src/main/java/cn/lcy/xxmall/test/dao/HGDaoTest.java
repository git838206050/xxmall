package cn.lcy.xxmall.test.dao;

import cn.lcy.xxmall.dao.DbaProductMapper;
import cn.lcy.xxmall.exception.MyDaoException;
import cn.lcy.xxmall.exception.MyFormPropertyException;
import cn.lcy.xxmall.pojo.DbaProduct;
import cn.lcy.xxmall.test.base.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @Author LCY
 * @Date 2017/12/6 23:25
 */
public class HGDaoTest extends SpringJunitTest {
    @Autowired
    private DbaProductMapper dbaProductMapper;


    @Test
    public void Test(){
        try {
            DbaProduct dbaProduct = new DbaProduct();
            for (int i = 35; i < 40; i++) {
                dbaProduct.setKeyword("key" + i);
                dbaProduct.setProdictid(1);
                dbaProduct.setPriority((byte) 50);
                dbaProductMapper.insert(dbaProduct);
                if (i == 38) {
//                    throw new MyDaoException();
                }
            }
        }catch (Exception e){
            System.out.println("报错了");
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
