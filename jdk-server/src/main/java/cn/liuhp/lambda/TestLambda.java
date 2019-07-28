package cn.liuhp.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @description: lambda例子
 * 左右遇一可省略：一个参数省()，一个语句省{} return 都可以省。
 * @author: liuhp534
 * @create: 2019-07-27 10:55
 */
public class TestLambda {

    public static void main(String[] args) {
        //fun1();
        fun4();
    }


    private static void fun1() {
        int num = 10;// 可以省略final,1.8之后
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hi" + num);
            }
        });
        t1.start();
        Runnable r = () -> System.out.println("hello" + num);
        Thread t = new Thread(r);
        t.start();
    }

    /*
    * 函数式接口FunctionalInterface
    * */
    private static void fun2() {
        Consumer<String> c = (x) -> System.out.println(x.length());
        c.accept("hhh");
    }

    /*
    * 扩号可省
    * */
    private static void fun3() {
        Comparator<Integer> c = (x, y) -> {//大括号return不能省
            /*if ((x.length() - y.length()) > 0) {
                return 1;
            } else {
                return -1;
            }*/
           return Integer.compare(x, y);
        };
    }

    /*
    * 匿名内部类的实现
    * */
    private static void fun4() {
        Fun result = (x, y) -> x + y;
        Integer value = operation(100, 20, (x , y) -> x + y);
        System.out.println(value);
    }

    private static Integer operation(Integer x, Integer y, Fun fun) {
        return fun.operation(x, y);
    }


}
interface Fun {

    Integer operation(Integer x, Integer y);
}
