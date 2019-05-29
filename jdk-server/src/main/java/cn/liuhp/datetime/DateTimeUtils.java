package cn.liuhp.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @description: 日期时间工具
 * @author: hz16092620
 * @create: 2019-04-10 14:16
 */
public class DateTimeUtils {
    /**日期*/
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**24小时制，日期+时间*/
    public static final String YYYY_MM_DD_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    /*
    * 1.7 处理时间的类SimpleDateFormat，是线程不安全的。
    * 解决方案：
    * 1、使用synchroinzed加锁，高并发影响性能；
    * 2、使用DateUtils每次都创建一个实例，频繁的创建销毁对象，影响性能；
    * 3、通过ThreadLocal为每个线程创建一个SimpleDateFormat；
    * */

    //----------------1方案----------------
    private static final SimpleDateFormat synchronizedDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_mm_ss);

    /*时间转字符串格式*/
    public static String formatDateTime(Date dateTime) {
        synchronized (synchronizedDateFormat) {
            return synchronizedDateFormat.format(dateTime);
        }
    }
    /*字符串转时间格式*/
    public static Date parseDateTime(String dateTime) {
        synchronized (synchronizedDateFormat) {
            try {
                return synchronizedDateFormat.parse(dateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }

    //----------------2方案----------------
    /*时间转字符串格式*/
    public static String formatDateTime2(Date dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_mm_ss);
        return dateFormat.format(dateTime);
    }
    /*字符串转时间格式*/
    public static Date parseDateTime2(String dateTime) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_mm_ss);
            return dateFormat.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
    //----------------3方案----------------
    private static final ThreadLocal<DateFormat> dateTimeThreadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(YYYY_MM_DD_HH_mm_ss);
        }
    };
    /*时间转字符串格式*/
    public static String formatDateTime3(Date dateTime) {
        return dateTimeThreadLocal.get().format(dateTime);
    }
    /*字符串转时间格式*/
    public static Date parseDateTime3(String dateTime) {
        try {
            return dateTimeThreadLocal.get().parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
    //----------------jdk1.8的方案 DateTimeFormatter线程是安全的，不可变类。需要去研究下？？？----------------
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_mm_ss);
    /*时间转字符串格式*/
    public static String formatDate4(LocalDateTime date) {
        return formatter.format(date);
    }
    /*字符串转时间格式*/
    public static LocalDateTime parse4(String dateNow) {
        return LocalDateTime.parse(dateNow, formatter);
    }

}
