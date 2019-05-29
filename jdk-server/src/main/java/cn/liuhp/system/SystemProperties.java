package cn.liuhp.system;

/**
 * @description: java 系统属性
 * @author: hz16092620
 * @create: 2019-04-23 15:47
 */
public class SystemProperties {

    public static void main(String[] args) {
        m1();
    }


    private static void m1() {
        System.out.println(System.getProperty("sun.arch.data.model"));//JVM 是 32 位 还是 64 位？
    }
}
