package cn.liuhp.keyword;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-18 10:38
 */
public class FinalTest {

    private int x;//这个初始化默认是0

    private final int i;

    {
        i = 100;
    }

    public static void main(String[] args) {
        fun2();
    }

    /*
    * final成员变量必须初始化
    * */
    private static void fun2() {
        final int a ;//只能赋值一次
        FinalTest finalTest = new FinalTest();
        System.out.println(finalTest.i);
        a = finalTest.i;
        System.out.println(a);
        System.out.println(finalTest.x);
    }

    /*
    * 1.8之后，匿名内部类使用外部变量，不需要加final
    * 但是for循环的变量不能直接使用
    * */
    private static void fun1() {
        int inner = 100;
        new Thread(() -> {
            System.out.println(inner);
        }).start();

        for (int i =0; i < 10; i ++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(finalI);
            }).start();
        }
    }
}
