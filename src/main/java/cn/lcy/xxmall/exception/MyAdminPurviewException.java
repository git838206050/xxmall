package cn.lcy.xxmall.exception;

/**
 * 后台权限管理
 * @Author LCY
 * @Date 2017/11/19 3:42
 */
public class MyAdminPurviewException extends Exception{
    public MyAdminPurviewException(){
        super();
    }

    public MyAdminPurviewException(String message) {
        super(message);
    }

    public MyAdminPurviewException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyAdminPurviewException(Throwable cause) {
        super(cause);
    }
}
