package cn.lcy.xxmall.exception;

/**
 * 定义字段验证错误
 * @Author LCY
 * @Date 2017/11/19 3:50
 */
public class MyFormPropertyException extends Exception {
    public MyFormPropertyException(){
        super();
    }

    public MyFormPropertyException(String message) {
        super(message);
    }

    public MyFormPropertyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyFormPropertyException(Throwable cause) {
        super(cause);
    }
}
