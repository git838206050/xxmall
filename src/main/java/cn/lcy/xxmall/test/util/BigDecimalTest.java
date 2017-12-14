package cn.lcy.xxmall.test.util;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author LCY
 * @Date 2017/12/8 16:44
 */
public class BigDecimalTest {
    @Test
    public void bigDecimal(){
        BigDecimal a = new BigDecimal(1.0);
        BigDecimal b = new BigDecimal(0);
        System.out.println(a.compareTo(b));
    }
}
