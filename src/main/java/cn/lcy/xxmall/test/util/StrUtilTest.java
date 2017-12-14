package cn.lcy.xxmall.test.util;

import cn.lcy.xxmall.util.StrUtil;
import org.junit.Test;

/**
 * @Author LCY
 * @Date 2017/11/8 15:28
 */
public class StrUtilTest {
    @Test
    public void testStrUtil(){
//        System.out.println(StrUtil.validateEmail("123456@qq.com"));


//        String str = "<html>";
//        System.out.println(new StrUtil().dislodgeAllTag(str));


        String str = "<       s      c      r      i      p \n" +
                "t >";
        String str2 = "<ScrIpt src=\"/sxxmall/plugin/jquery/jquery.cookie.js\">" +
                "<ScrIpt src=\"/sxxmall/plugin/jquery/jquery.cookie.js\">" +
                "<ScrIpt src=\"/sxxmall/plugin/jquery/jquery.cookie.js\">" +
                "</script></script></script><ScrIpt src=\"/sxxmall/plugin/jquery/jquery.cookie.js\"></script>";
//        System.out.println(new StrUtil().dislodgeScriptTag(str2));


        String aTag = "asd<a href=\"eed\">abc</a>bdfsd<a href=\"ee123d\">ab132c</a>bdf";
        System.out.println(new StrUtil().getATagHear(aTag).get(0).toString());
    }
}
