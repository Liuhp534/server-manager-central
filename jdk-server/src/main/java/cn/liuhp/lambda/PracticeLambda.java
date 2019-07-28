package cn.liuhp.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 练习lambda
 * @author: liuhp534
 * @create: 2019-07-28 11:06
 */
public class PracticeLambda {



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
