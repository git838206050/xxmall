package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.BgPurviewMapper;
import cn.lcy.xxmall.pojo.BgPurview;
import cn.lcy.xxmall.pojo.BgPurviewExample;
import cn.lcy.xxmall.service.BgPurviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/3 10:25
 */
@Service
public class BgPurviewServiceImpl implements BgPurviewService {
    @Autowired
    private BgPurviewMapper bgPurviewMapper;

    @Override
    public List<BgPurview> getBgPurviews() {
        BgPurviewExample bgPurviewExample = new BgPurviewExample();
        BgPurviewExample.Criteria criteria = bgPurviewExample.or();
        criteria.andIdIsNotNull();
        return bgPurviewMapper.selectByExample(bgPurviewExample);
    }

    @Override
    public List<BgPurview> getBgPurviewsByPurviewType(Integer purviewTypeId) {
        BgPurviewExample bgPurviewExample = new BgPurviewExample();
        BgPurviewExample.Criteria criteria = bgPurviewExample.or();
        criteria.andPurviewtypeEqualTo(purviewTypeId);
        return bgPurviewMapper.selectByExample(bgPurviewExample);
    }

    @Override
    public List<BgPurview> getBgPurviewsByAction(String action) {
        BgPurviewExample bgPurviewExample = new BgPurviewExample();
        BgPurviewExample.Criteria criteria = bgPurviewExample.or();
        criteria.andActionEqualTo(action);
        return bgPurviewMapper.selectByExample(bgPurviewExample);
    }
}
