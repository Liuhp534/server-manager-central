package cn.liuhp;

import sun.security.ec.SunEC;


/**
 * @description: testclassloader
 * @author: liuhp534
 * @create: 2020-02-08 15:41
 */
public class TestClassLoader {

    public static void main(String[] args) {
        System.out.println(TestClassLoader.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(SunEC.class.getClassLoader());
    }


}
