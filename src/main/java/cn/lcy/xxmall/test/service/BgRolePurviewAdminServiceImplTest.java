package cn.lcy.xxmall.test.service;

import cn.lcy.xxmall.service.BgRolePurviewAdminService;
import cn.lcy.xxmall.test.base.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试获取权限
 * 已被取消，使用权限组代替。具体类baseService
 * @Author LCY
 * @Date 2017/11/3 14:38
 */
public class BgRolePurviewAdminServiceImplTest extends SpringJunitTest {
    @Autowired
    private BgRolePurviewAdminService bgRolePurviewAdminService;
    @Test
    public void TestBgRolePurviewAdminServiceImpl(){
//        System.out.println( bgRolePurviewAdminService.isAuthorize(1,4) );
    }
}
