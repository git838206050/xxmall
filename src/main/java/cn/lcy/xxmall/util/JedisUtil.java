package cn.lcy.xxmall.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @Author LCY
 * @Date 2017/10/26 7:55
 */
@Component
public class JedisUtil {
    final static String REDIS_HOST = "localhost";

    /**
     * 获取redis对象
     * @return
     */
    public static Jedis getJedis(){
        Jedis jedis = new Jedis(REDIS_HOST);
        return jedis;
    }
}
