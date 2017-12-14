package cn.lcy.xxmall.test.service;

import cn.lcy.xxmall.pojo.BgPurview;
import cn.lcy.xxmall.service.BgPurviewService;
import cn.lcy.xxmall.test.base.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/3 10:28
 */
public class BgPurviewServiceImplTest extends SpringJunitTest{
    @Autowired
    private BgPurviewService BgPurviewService;

    @Test
    public void testBgPurviewService(){
        List<BgPurview> bgPurviewList = BgPurviewService.getBgPurviewsByPurviewType(1);

        for(int i=0; i<bgPurviewList.size(); i++){
            System.out.println(bgPurviewList.get(i).getName());
        }
    }

}
