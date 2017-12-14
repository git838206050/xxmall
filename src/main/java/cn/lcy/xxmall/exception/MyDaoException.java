package cn.lcy.xxmall.exception;


/**
 * 处理
 * @Author LCY
 * @Date 2017/12/7 0:24
 */
public class MyDaoException extends Exception{

    public MyDaoException(){
        super();
        System.out.println("执行错误了");
    }

    public MyDaoException(String message) {
        super(message);
    }

    public MyDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDaoException(Throwable cause) {
        super(cause);
    }
}
