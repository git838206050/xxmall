package cn.lcy.xxmall.filter.aop.service.shop.fieldvalidate;

import cn.lcy.xxmall.pojo.Admin;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 店铺字段验证
 * @Author LCY
 * @Date 2017/11/18 22:43
 */
//@Component
//@Aspect
public class ShopFielDvalidate {
//    @Pointcut("execution(* cn.lcy.xxmall.pojo.Admin.setNickname(String))")
//    private void getAdmins(){}
//
//    @After(value="getAdmins()")
//    public void after(){
//        System.out.println("方法执行后执行3.....");
//    }
//
//    @Before(value="getAdmins()")
//    public void filterLogin(){
//        System.out.println("方法执行前执行3............");
//    }
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
//        Object[] objArr = jp.getArgs();
//        /**
//         *
//         * method-execution
//         Admin cn.lcy.xxmall.service.AdminService.getAdminByAdminName(String)
//         cn.lcy.xxmall.service.impl.AdminServiceImpl@6889b78f
//         execution(public abstract cn.lcy.xxmall.pojo.Admin cn.lcy.xxmall.service.AdminService.getAdminByAdminName(java.lang.String))
//         execution(AdminService.getAdminByAdminName(..))
//         */
//        System.out.println(jp.getKind());
//        System.out.println(jp.getSignature());
//        System.out.println(jp.getTarget().toString());
//        System.out.println(jp.toLongString());
//        System.out.println();
//        Admin admin= (Admin) jp.getThis();
//        admin.setNickname("ab1111c");
//        for(Object obj:objArr){
//            System.out.println(obj.getClass().getName());
//            System.out.println(obj.toString());
//            System.out.println(obj);
//        }
//        System.out.println("方法执行最后.3.....................................................");
//    }
}
