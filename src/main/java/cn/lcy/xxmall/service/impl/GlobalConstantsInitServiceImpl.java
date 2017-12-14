package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.PageMessageMapper;
import cn.lcy.xxmall.pojo.PageMessage;
import cn.lcy.xxmall.pojo.PageMessageExample;
import cn.lcy.xxmall.service.GlobalConstantsInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/10/20 20:03
 */
@Service
public class GlobalConstantsInitServiceImpl implements GlobalConstantsInitService {
    @Autowired
    PageMessageMapper pageMessageMapper;

    @Override
    public PageMessage getMessagevalueByMessageKey(String messageKey) {
        PageMessageExample pageMessageExample = new PageMessageExample();
        PageMessageExample.Criteria criteria = pageMessageExample.or();
        criteria.andMessagekeyEqualTo(messageKey);
        List<PageMessage> pageMessageList = pageMessageMapper.selectByExample(pageMessageExample);
        return pageMessageList.get(0);
    }

    @Override
    public List<PageMessage> getMessages() {
        PageMessageExample pageMessageExample = new PageMessageExample();
        PageMessageExample.Criteria criteria = pageMessageExample.or();
        // 获取key值不等于1的所有数据，也就是获取所有数据
        criteria.andMessagekeyNotEqualTo("-1");
        return pageMessageMapper.selectByExample(pageMessageExample);
    }
}
