package cn.lcy.xxmall.test.dao;

import cn.lcy.xxmall.dao.UserMapper;
import cn.lcy.xxmall.pojo.User;
import cn.lcy.xxmall.test.base.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author LCY
 * @Date 2017/11/10 16:44
 */
public class testUserDao extends SpringJunitTest{
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        User user = new User();
        user.setUsername("usernam1332c");
        user.setNickname("usernamexa");
        System.out.println(userMapper.insert(user));
        user.setUsername("usernam13322c");
        user.setNickname("usernamexx");
        System.out.println(userMapper.insert(user));
//        System.out.println(test2Mapper.abc(1).getTest1().getTestname());
    }
}
