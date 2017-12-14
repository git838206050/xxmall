package cn.lcy.xxmall.test.dao;

import cn.lcy.xxmall.dao.TestdaoMapper;
import cn.lcy.xxmall.pojo.Testdao;
import cn.lcy.xxmall.pojo.TestdaoExample;
import cn.lcy.xxmall.test.base.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/10 16:44
 */
public class testTestDao extends SpringJunitTest{
    @Autowired
    private TestdaoMapper testdaoMapper;
    @Test
    public void test(){
        // 启动过程会消耗300ms时间

        Testdao testdao = new Testdao();
//        for(int i = 1000000,j=10000000; i<=5000000; ++i,j++){
//            testdao.setTestname("name"+i);
//            testdao.setTesttype(i);
//            testdao.setTesttype2(j);
//            testdaoMapper.insert(testdao);
//        }

//        System.out.println("--------");

        TestdaoExample testdaoExample = new TestdaoExample();
        TestdaoExample.Criteria criteria = testdaoExample.or();
//        List<Integer> idList = new ArrayList<Integer>();
//        for(int i =1; i<=100; i++){
//            idList.add((int)Math.round(Math.random()*100000)+5);
//        }
//        criteria.andIdIn(idList);
        criteria.andTestnameEqualTo("name4800000");
        System.out.println(testdaoMapper.selectByExample(testdaoExample).size()+"=======================================");
    }
}
