package cn.liuhp.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {


    public static void main(String[] args) {
        //fun1();
        //fun2();
        //fun3();
        //fun4();
        fun5();
        //fun6();
    }





    /*
    * 去重
    * */
    private static void fun1() {
        List<String> list = Arrays.asList("1", "2", "1", "4");

        list.stream().distinct().forEach(str -> System.out.println(str));
    }

    /*
    *list<String> 转List<Long>
    * */
    private static void fun2() {
        String[] insureNumArray = {"1", "2", "1", "4"};
        List<Long> insureNumList = Arrays.stream(insureNumArray).map(str -> Long.valueOf(str)).collect(Collectors.toList());

        insureNumList.stream().forEach(insureNum -> {
            if (insureNum instanceof Long) {
                System.out.println(insureNum);
            }
        });
    }

    /*
    * list转map
    * 可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
    * */
    private static void fun3() {
        List<String> list = Arrays.asList("1", "2", "1", "4");

        Map<String, String>  map = list.stream().collect(Collectors.toMap(str -> str, str -> str, (k1, k2) -> k1));

        map.forEach((k, v) -> {
            System.out.println("k=" + k);
            System.out.println("v=" + v);
        });
    }


    /*
    * filter过滤
    * */
    private static void fun4() {
        List<String> list = Arrays.asList("1", "2", "1", "4");

        list = list.stream().filter(str -> {
            if (str.equals("2")) {
                return false;
            } else {
                return true;
            }
        }).collect(Collectors.toList());

        list.forEach(str -> System.out.println(str));
    }


    /*
    *并行的
    * */
    private static void fun5() {
        List<String> list = Arrays.asList("1", "2", "1", "4");

        long start = System.currentTimeMillis();
        list.stream().forEach(str -> {
            System.out.println(str);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("用时=" + (end - start));
        start = System.currentTimeMillis();
        list.parallelStream().forEach(str -> {
            System.out.println(str);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        end = System.currentTimeMillis();
        System.out.println("用时=" + (end - start));
    }

    /*
    * flatMap的处理
    * map一对一的
    * flatmap一对多的
    * */
    private static void fun6() {
        String[] words = new String[]{"Hello","World"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        a.forEach(System.out::println);

        //System.out.println(words);

        List<String> ab = Arrays.stream(words)
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        ab.forEach(System.out::println);
    }

}
