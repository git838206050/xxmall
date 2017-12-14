package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.PageMessage;

import java.util.List;

/**
 *
 */
public interface GlobalConstantsInitService {
    /**
     * 根据消息Key获取Value
     * 初始化全局常量，用于显示在前台的信息常量
     */
    PageMessage getMessagevalueByMessageKey(String messageKey);

    /**
     * 获取所有全局变量
     * @return
     */
    List<PageMessage> getMessages();
}
