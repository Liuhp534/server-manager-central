package cn.liuhp.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/*
* Calendar的使用 kælɪndər
* */
public class CalendarUtils {


    public static void main(String[] args) {
        //fun1();
        fun2();
    }


    /*
     * Calendar与Date的使用
     * */
    private static void fun1() {
        Date d1 = new Date();

        Calendar calendar = Calendar.getInstance();
        Date d2 = calendar.getTime();

        System.out.println("d1=" + d1);
        System.out.println("d2=" + d2);
    }

    /*
    * Calendar的使用
    * */
    private static void fun2() {
        Calendar calendar = Calendar.getInstance();
        //月份需要加一个
        System.out.println(String.format("时间=%s年%s月%s日 %s:%s:%s",
                calendar.get(Calendar.YEAR),
                (calendar.get(Calendar.MONTH) + 1),
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND)));
        LocalDateTime localDateTime = LocalDateTime.now();
        String jdk8DateTime = DateTimeUtils.formatDate4(localDateTime);
        System.out.println("jdk8时间=" + jdk8DateTime);
        System.out.println("jdk8时间=" + DateTimeUtils.parse4(jdk8DateTime));
        System.out.println("jdk7时间=" + DateTimeUtils.formatDateTime3(calendar.getTime()));
    }

    /*
    * 有空通过线程池提交线程看是否线程安全，将字符串dateTime-》日期格式-》工具转为字符串2，比较是否一致
    * */
    private static void fun3() {
        //TODO
    }

}
