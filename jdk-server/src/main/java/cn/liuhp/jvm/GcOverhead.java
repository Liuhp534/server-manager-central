package cn.liuhp.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: oom
 * @author: liuhp534
 * @create: 2020-02-05 19:39
 */
public class GcOverhead {

    public static void main(String[] args) {
        fun1();
    }


    public static void fun1() {
        //byte[] bytes = new byte[20 * 1024 * 1024];
        int i = 0;
        try {
            List<String> list = new ArrayList<>();

            while (true) {
                list.add(String.valueOf(i++));
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("i=" + i);
        }
    }
}
