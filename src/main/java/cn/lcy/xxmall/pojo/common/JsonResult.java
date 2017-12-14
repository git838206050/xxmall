package cn.lcy.xxmall.pojo.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于接收前端发送过来的json格式数据
 */
@Component
public class JsonResult {
    private String errorCode;

    private String message;

    private Map<Object, Object> item = new HashMap<Object, Object>();

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<Object, Object> getItem() {
        return item;
    }

    public void setItem(Map<Object, Object> item) {
        this.item = item;
    }


    public JsonResult() {
        super();
    }

}
