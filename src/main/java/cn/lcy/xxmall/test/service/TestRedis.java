package cn.lcy.xxmall.test.service;

import cn.lcy.xxmall.util.DateUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @Author LCY
 * @Date 2017/10/25 19:30
 */
public class TestRedis {
    @Test
    public void TestReids(){
        Jedis jedis = new Jedis("localhost");
//        for(int i=0; i<10000; i++){
//            System.out.println("aaa: "+jedis.get("aaa"));
//        }

        // 测试保存map类型redis。
        // 注意：如果该key存在于redis中，并且类型不一致的话会报错
        Map map = new HashMap<String, Object>();
        map.put("token","abc");
        map.put("endTime","abc2");
//        jedis.hmset("aaa",map);

//        List<String> testMap = jedis.hmget("aaza","aaa","s");
//        System.out.println(testMap.get(1));

        // 获取所有redis的key
        System.out.println("系统中所有键如下：");
        System.out.println(DateUtil.getDate().getTime());
//        System.out.println(jedis.ttl("admin_4"));
//        System.out.println(jedis.pttl("admin_4"));
//        jedis.hmset("admin_4",map);
//        jedis.expire("admin_4",10);
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
            System.out.println( jedis.hmget(key,"token","endTime").get(0) );
            System.out.println( jedis.hmget(key,"token","endTime").get(1) );
        }
    }
}
