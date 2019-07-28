package cn.liuhp.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @description: 练习lambda
 * @author: liuhp534
 * @create: 2019-07-28 11:06
 */
public class PracticeLambda {


    @Test
    public void test4() {
        Function<Integer, List<String>> f1 = (x) -> new ArrayList<>(x);
        Function<Integer, List<String>> f2 = ArrayList::new;
        List<String> list = f2.apply(10);//根据参数列表参数的个数，来确定那个构造函数
        System.out.println(list.size());


        Function<Integer, String[]> f3 = (x) -> new String[x];
        Function<Integer, String[]> f4 = String[]::new;
        String[] strs = f4.apply(20);
        System.out.println(strs.length);
    }

    @Test
    public void test3() {
        Consumer<String> c = x -> System.out.println(x);
        Consumer<String> c1 = System.out::println;//对象::实例方法
        c1.accept("hello");

        Comparator<Integer> c2 = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> c3 = Integer::compare;//类::静态方法

        BiPredicate<String, String> b1 = (x, y) -> x.equals(y);
        BiPredicate<String, String> b2 = String::equals;//类::实例方法
    }


    @Test
    public void test2() {
        LambdaHandler<Integer, Double> handler = (x, y) -> Double.valueOf(x + y);
        System.out.println(handler.operation(10, 20));
    }

    /*
     * 利用lambda 实现Comparator接口
     * */
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("f");
        list.add("a");

        Collections.sort(list, (x, y) -> x.compareTo(y));

        for (String str : list) {
            System.out.println(str);
        }
    }
}
