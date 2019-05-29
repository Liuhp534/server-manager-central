package cn.liuhp.list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @description: set和list
 * @author: hz16092620
 * @create: 2019-04-29 17:28
 */
public class SetAndList {


    public static void main(String[] args) {
        m1();
    }

    /*
    * set的使用
    * */
    private static void m1() {
        Set<String> s1 = new HashSet<>();
        s1.add(null);//可以有null值
        System.out.println(s1.size());
    }

    private static void m2() {
        Set<String> s1 = new HashSet<>();
        s1.add("111");//可以有null值
        Iterator<String> it = s1.iterator();
    }
}
