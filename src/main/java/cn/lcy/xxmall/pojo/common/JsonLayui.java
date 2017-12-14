package cn.lcy.xxmall.pojo.common;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 专门为前端Layui做的一个json返回实体类
 * 返回的变量名都是根据layui框架api提供命名规范。不能自行设置变量名称
 * @Author LCY
 * @Date 2017/10/30 9:54
 */
@Component
public class JsonLayui {
    private List<Object> data = new ArrayList<Object>();
    private Integer code;   // 信号码 在前端框架中必须返回0才能表示传值成功
    private String msg;     // 信息
	private Long count;  // 总信息数量，实现分页时需要
    private Long page;   // 当前页
    private Long limit;  // 每页显示多少数量

    public List<Object> getData() {
        return data;
    }

    static public <E> List<Object> toObject(List<E> list){
        List<Object> objlist = new ArrayList<Object>();
        for(Object e : list){
            Object obj = (Object)e;
            objlist.add(obj);
        }
        return objlist;
    }
    public void setData(List<Object> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public JsonLayui() {
        super();
    }
}
