package cn.liuhp.wheel.util;

import org.springframework.util.StopWatch;

/**
 * @description: 秒表工具类
 * @author: hz16092620
 * @create: 2019-06-18 09:52
 */
public class StopWatchUtils {


    public static void main(String[] args) throws InterruptedException {
        stopWatch();
    }

    /*秒表使用例子*/
    private static void stopWatch() throws InterruptedException {
        // 定义一个计数器
        StopWatch stopWatch = new StopWatch("统一一组任务耗时");
         // 统计任务一耗时
        stopWatch.start("任务一");
        Thread.sleep(1000);
        stopWatch.stop();
        // 统计任务二耗时
        stopWatch.start("任务二");
        Thread.sleep(2000);
        stopWatch.stop();//如果不stop那么只会记录打印stop的任务
        // 打印出耗时
        String result = stopWatch.prettyPrint();
        System.err.println(result);
    }
}
