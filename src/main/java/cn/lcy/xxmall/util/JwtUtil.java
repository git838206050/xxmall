package cn.lcy.xxmall.util;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author LCY
 * @Date 2017/10/25 20:58
 */
@Component
public class JwtUtil {
    // 创建jwt的盐值  0：管理员登录使用， 1：客户登录使用
    static final String[] SALT = {"ascerrt328ouyfserxczxsrryuimjkhgf","asdvzxc89765gb12vcdf"};
    /**
     * 创建JWT
     * 加密规则：((id)+(exp)+(iat)+(SALT)).md5()
     * @param id jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
     * @param exp jwt的过期时间，这个过期时间必须要大于签发时间
     * @param iat jwt的签发时间
     * @param saltNum jwt使用对象，0：管理员，1：客户
     * @return null 表示加密失败
     */
    public static String createJWT(Integer id, Date exp, Date iat,byte saltNum){
        String resule = null;
        if(id==null || exp==null || iat==null){
            return null;
        }

        StringBuffer str = new StringBuffer();
        str.append( String.valueOf(id));
        str.append( DateUtil.convertDateToString(exp,1) );
        str.append( DateUtil.convertDateToString(iat,1) );
        str.append( SALT[saltNum] );
        resule = Md5Util.md5(str.toString());
        return resule;
    }
}
