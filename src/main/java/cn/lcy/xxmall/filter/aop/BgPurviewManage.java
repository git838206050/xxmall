package cn.lcy.xxmall.filter.aop;

import cn.lcy.xxmall.pojo.Admin;
import cn.lcy.xxmall.pojo.common.JsonResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/17 16:46
 */
//@Component
//@Aspect
public class BgPurviewManage {
//    @Autowired

//    @Pointcut("execution(* cn.lcy.xxmall.service.impl.AdminServiceImpl.getAdmins())")
//    private void getAdmins(){}
//
//    @After(value="getAdmins()")
//    public void after(){
//        System.out.println("方法执行后执行.....");
//    }
//
//    @Before(value="getAdmins()")
//	public void filterLogin(){
//        System.out.println("方法执行前执行............");
//	}
//
//    /**
//     * @param jp
//     * JoinPoint
//     java.lang.Object[] getArgs()：获取连接点方法运行时的入参列表；
//     Signature getSignature() ：获取连接点的方法签名对象；
//     java.lang.Object getTarget() ：获取连接点所在的目标对象；
//     java.lang.Object getThis() ：获取代理对象本身；
//     * @param rtv 获取切面返回结果
//     */
//    @AfterReturning(value="getAdmins()",returning="rtv")
//    public void startRecordLog(JoinPoint jp, Object rtv){
//        jp.getArgs();
//        System.out.println("方法执行最后......................................................");
//    }
}
