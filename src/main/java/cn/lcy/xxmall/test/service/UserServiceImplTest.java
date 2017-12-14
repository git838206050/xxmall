package cn.lcy.xxmall.test.service;

import cn.lcy.xxmall.pojo.User;
import cn.lcy.xxmall.service.UserService;
import cn.lcy.xxmall.test.base.SpringJunitTest;
import cn.lcy.xxmall.util.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/8 12:27
 */
public class UserServiceImplTest extends SpringJunitTest {
    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceImpl(){
//        List<User> userList = userService.getUsers();
//        for(int i=0; i<userList.size(); i++){
//            System.out.println(userList.get(i).getUsername());
//        }

//        User user = userService.login("user","123123");
//        System.out.println(user.getUsername());

        User user = new User();
        for(int i=99; i<1099; i++){
            user.setPassword("123123");
            user.setUsername("randomName"+String.valueOf(i));
            user.setNickname("randomNickname_"+String.valueOf(i));
            user.setEmail("testEmail"+String.valueOf(Math.random()*10+1000)+"@qq.com");
            user.setHeaderurl(null);
            user.setAnswer("问题");
            user.setQuestion("答案");
            user.setProhibitlogintime(DateUtil.getDate());
            user.setCreattime(DateUtil.getDate());
            userService.insertUser(4,user, null);
        }
    }
}
