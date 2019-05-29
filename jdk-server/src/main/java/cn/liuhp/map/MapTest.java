package cn.liuhp.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: map相关的操作
 * @author: hz16092620
 * @create: 2019-05-06 15:21
 */
public class MapTest {


    public static void main(String[] args) {
        m2();
    }

    private static void m4() {
        HashSet set = new HashSet();
    }

    private static void m3() {
        Map<String, Object> linkedMap = new LinkedHashMap<>();
    }

    /*计算临界值扩容的*/
    private static void m2() {
        int n = 50 - 1;
        System.out.println(n);
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
    }

    private static void m1() {
        Map<String, Object> map = new HashMap<>();
    }
}
