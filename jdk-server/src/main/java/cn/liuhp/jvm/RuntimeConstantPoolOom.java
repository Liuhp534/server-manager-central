package cn.liuhp.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 方法区及运行时常量池溢出
 * Error occurred during initialization of VM
 * MaxMetaspaceSize is too small. 这个不然配置那么小啊
 * @author: hz16092620
 * @create: 2019-04-24 16:57
 */
public class RuntimeConstantPoolOom {

    public static void main(String[] args) {
        test1();
    }

    private static void test2() {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {//
            list.add(String.valueOf(i++).intern());
        }
    }

    private static void test1() {
        String s1 = new String("hello");
        String s2 = s1.intern();//理论上是常量池中看是否有，如果有，则返回，如果是先new呢？我理解的是false
        System.out.println("s2 = " + s2);
        System.out.println(s1 == s2);
        System.out.println("----------------------------------");
        String s3 = "hello";
        String s4 = new String("hello").intern();
        System.out.println(s3 == s2);//这个应该是true
        System.out.println(s4 == s2);//s4 == s3 也是一样的结果
    }

}
