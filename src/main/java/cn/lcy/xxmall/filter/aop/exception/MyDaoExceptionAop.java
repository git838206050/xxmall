package cn.lcy.xxmall.filter.aop.exception;

import cn.lcy.xxmall.exception.MyDaoException;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * dao 回滚
 * @Author LCY
 * @Date 2017/12/7 0:27
 */
@Component
@Aspect
public class MyDaoExceptionAop {
    @ExceptionHandler(MyDaoException.class)
    public void handleException(Exception e) {
        System.out.println("AOP执行");
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
