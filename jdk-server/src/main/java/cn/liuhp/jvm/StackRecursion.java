package cn.liuhp.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 函数递归
 * 递归调用中栈溢出原因；
 * 那么过多的递归调用为什么会引起栈溢出呢？
 * 事实上，函数调用的参数是通过栈空间来传递的，在调用过程中会占用线程的栈资源。
 * 而递归调用，只有走到最后的结束点后函数才能依次退出，而未到达最后的结束点之前，
 * 占用的栈空间一直没有释放，如果递归调用次数过多，就可能导致占用的栈资源超过线程的最大值，
 * 从而导致栈溢出，导致程序的异常退出。-Xss128k 最小108k
 * @author: hz16092620
 * @create: 2019-04-23 16:55
 */
public class StackRecursion {

    public static void main(String[] args) throws Throwable {
        List<String> objs = new ArrayList<>();
        for (int i = 0; i < 1000000; i ++) {
            objs.add("导致程序的异常退出");
        }
        m2(objs);
        m1();
    }

    private static void m2(List<String> objs) {
        System.out.println(objs.size());
    }

    /*递归栈溢出*/
    private static void m1() {
        StackRecursion sl = new StackRecursion();
        try {
            sl.stackLevel();
        } catch (StackOverflowError e) {
            e.printStackTrace();
            System.out.println(sl.level);
        }
    }

    private int level = 1;

    public void stackLevel() {
        //String buf = "";
        /*String buf1 = "";
        String buf2 = "";
        String buf3 = "";
        String buf4 = "";*/
        level++;
        stackLevel();
    }
}
