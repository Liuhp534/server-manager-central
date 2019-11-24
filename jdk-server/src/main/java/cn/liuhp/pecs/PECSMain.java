package cn.liuhp.pecs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PECSMain {


    private static void fun1() {
        List<? extends Fruit> list1 = new ArrayList<Fruit>();
        List<? extends Fruit> list2 = new ArrayList<Apple>();
        List<? super Apple> list3 = new ArrayList<Apple>();
        List<? super Apple> list4 = new ArrayList<Fruit>();
    }

    //方法一
    public static <T extends Fruit> void get(List<T> list) {
        list.get(0);
    }


    /*
    * 理解混乱啊
    * */
    public static void fun2(Collection<? super Number> apples) {
        apples.add(new Integer(1));
    }

    /*
    * <? super T>：通配符？的类型在T和Object之间
    * */
    private static void fun3(List<? super Fruit> apples) {
        Fruit fruit = (Fruit) apples.get(0);
        Apple apple = (Apple) apples.get(0);
        apples.add(new Fruit());
        apples.add(new Apple());
    }

}
