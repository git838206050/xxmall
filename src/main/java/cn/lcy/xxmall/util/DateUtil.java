package cn.lcy.xxmall.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于处理时间的类
 */
@Component
public class DateUtil {
    static final String []TYPE = {"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss","yyyy年MM月dd日 HH时mm分ss秒"};
    static Date date;
    /**
     * 获取时间，利用静态方法配合@Component的单例类，
     * 使得每次获取当前时间不用重新new一个对象出来
     * @return
     */
    public static Date getDate(){
        date = new Date();
        return date;
    }

    public static Date getDate(Long timeLong){
        date = new Date(timeLong);
        return date;
    }

    /**
     * 用于String转换成Date
     * @param dateStr 需要转换的string 类型的时间
     * @param typeNum 时间的类型，对应TYPE常量的序号
     * @return
     */
    public static Date getDate(String dateStr, int typeNum){
        date = null;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(TYPE[typeNum]);
            date = sdf.parse(dateStr);
        }catch (Exception e){
            date = null;
        }finally {
            return date;
        }
    }

    /**
     * @param date 需要转换的时间
     * @param typeNum {"yyyy-MM-dd"}。转换成什么类型的格式 ，格式的序号对应着type[]的序号。从0开始
     * @return
     */
    public static String convertDateToString(Date date,int typeNum){
        SimpleDateFormat sdf = new SimpleDateFormat(TYPE[typeNum]);
        return sdf.format(date);
    }

    /**
     * 用于比较两个时间戳 的长短
     * @param date1 要比较的时间1
     * @param date2 要比较的时间2
     * @return 1表示时间1比时间2晚；2相反；0表示相同；null表示有至少一个时间为null
     */
    public static Integer compareTimeStamp(Date date1, Date date2){
        Integer result = null; // 比较结果
        if(date1 != null && date2 != null){
            Long timeStamp1 = date1.getTime();
            Long timeStamp2 = date2.getTime();
            if(timeStamp1 > timeStamp2){
                result = 1;
            }else if(timeStamp2 > timeStamp1){
                result = 2;
            }else{
                result = 0;
            }
        }
        return result;
    }

    /**
     * 对时间进行一个前进与后退的处理
     * @param date 需要处理的时间，不能为null，否则返回null值
     * @param AxisValue 前进或后退多长时间（单位：毫秒。如：30 * 60 * 1000 = 30分钟）
     * @return null表示无法处理
     */
    public static Date changeTimeAxis(Date date, Long AxisValue){
        Date result = null;
        if(date != null){
            Long timeLong = date.getTime() + AxisValue;
            result = DateUtil.getDate(timeLong);
        }
        return result;
    }
}
