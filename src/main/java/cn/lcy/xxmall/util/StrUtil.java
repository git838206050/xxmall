package cn.lcy.xxmall.util;

import cn.lcy.xxmall.constants.GlobalConstants;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author LCY
 * @Date 2017/10/27 8:51
 */
@Component
public class StrUtil {
    // 在拦截器中的输出
    public static void dealErrorReturn(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj){

        //设置返回数据的响应头
        httpServletResponse.setHeader("Access-Control-Allow-Origin", GlobalConstants.ajax_host);
        httpServletResponse.setHeader("Vary", "Origin");
        httpServletResponse.setHeader("Server", "Apache-Coyote/1.1");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            /* 设置响应头为Json */
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=UTF-8");


        PrintWriter writer = null;
        try {
            JSONObject jsonObject = new JSONObject(obj);
            writer = httpServletResponse.getWriter();
            writer.print(jsonObject);
        } catch (IOException ex) {
            // logger.error("response error",ex);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    /**
     * byte[] 转 String
     * @param bytes
     * @return
     */
    public static String newString(byte[] bytes){
        return new String(bytes);
    }

    /**
     * 验证邮箱格式
     * @param email
     * @return false:不合法格式，true:合法
     */
    public static boolean validateEmail(String email){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{1,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 将所有‘<’,'>’的标签替换成‘&lt;’和‘&gt;’
     * @param str
     * @return
     */
    public static String dislodgeAllTag(String str){
        str = str.replaceAll("<","&lt;");
        str = str.replaceAll(">","&gt;");
        return str;
    }

    /**
     * 将所有‘<ScrIpt’(忽略大小写) 替换成 ‘&lt;ScrIpt’
     * @param str
     * @return
     */
    public static String dislodgeScriptTag(String str){
        String pattern = "(<{1}\\s*s{1}\\s*c{1}\\s*r{1}\\s*i{1}\\s*p{1}\\s*t{1}\\s*)";
        // 忽略大小写,不忽略时取消Pattern.CASE_INSENSITIVE
        Pattern r = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = r.matcher(str);
        while (m.find()) {
            str = str.replaceAll(m.group(0),m.group(0).replaceAll("<","&lt;"));
        }
        return str;
    }

    /**
     * 获取所有<index></index>标签里面的hear 路径
     * @param str
     * @return
     */
    public static List<String> getATagHear(String str){
        List<String> returnUrl = new ArrayList<String>();
        String pattern = "(<{1}\\s*a{1}\\s*h{1}\\s*r{1}\\s*e{1}\\s*f{1}\\s*={1}\\s*\"{1}\\s*([^\"]*)\"{1})";
        // 忽略大小写,不忽略时取消Pattern.CASE_INSENSITIVE
        Pattern r = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = r.matcher(str);
        for (int i=2; m.find(); i++) {
            returnUrl.add(m.group(2));
            str = str.replaceAll(m.group(2),"");
        }
        return returnUrl;
    }

    /**
     * 过滤所有<index></index>标签里面的hear 路径。如<index href="baidu.com"></index> --> <index href=""></index>
     * @param str
     * @return
     */
    public static String dislodgeATagHear(String str){
        String pattern = "(<{1}\\s*a{1}\\s*h{1}\\s*r{1}\\s*e{1}\\s*f{1}\\s*={1}\\s*\"{1}\\s*([^\"]*)\"{1})";
        // 忽略大小写,不忽略时取消Pattern.CASE_INSENSITIVE
        Pattern r = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = r.matcher(str);
        for (int i=2; m.find(); i++) {
            str = str.replaceAll(m.group(2),"");
        }
        return str;
    }
}
