package cn.liuhp.pecs;


import java.util.ArrayList;
import java.util.List;

/*
* ? super T的情况的描述
* */
public class ESTest {




    /*
    * add的情况列举
    * */
    private static void fun1() {
        List<? super Fruit> apples = new ArrayList<>();

        apples.add(new Apple());
        apples.add(new Fruit());
        apples.add((Fruit) new Food());
        apples.add((Fruit) new Object());
        //apples.add(new Food());//不行，不确定超类是哪个类型，安全考虑不能直接加入
        //apples.add(new Object());//不行，不确定超类是哪个类型，安全考虑不能直接加入
        Fruit fruit = (Fruit) apples.get(0);//只能是object对象，如果转换类型可以
        Object obj = apples.get(0);//只能是object对象
        System.out.println(obj);
    }

    /*
    * 创建类型，情况列举
    *
    * */
    private static void fun2() {
        List<? super Fruit> fruits = new ArrayList<>();

        fruits = new ArrayList<Fruit>();
        fruits = new ArrayList<Food>();
        //fruits = new ArrayList<Apple>();//编译会报错 不是T的orT的超类型
    }
}
