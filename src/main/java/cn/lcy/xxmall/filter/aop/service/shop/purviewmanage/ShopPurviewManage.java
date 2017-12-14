package cn.lcy.xxmall.filter.aop.service.shop.purviewmanage;

import cn.lcy.xxmall.exception.MyAdminPurviewException;
import cn.lcy.xxmall.service.common.BaseService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author LCY
 * @Date 2017/11/19 2:53
 */
@Component
@Aspect
public class ShopPurviewManage {
    @Autowired
    private BaseService baseService;

    @Pointcut("execution(* cn.lcy.xxmall.service.impl.ShopServiceImpl.insert*(..))")
    private void inserts(){}


    @Before(value="inserts()")
    public void filterLogin(JoinPoint jp) throws MyAdminPurviewException {
        Object[] args = jp.getArgs();
        Integer adminId = (Integer)args[1];

        if( !baseService.isAuthorize(7,adminId) ){
            throw new MyAdminPurviewException();
        };
    }

}
