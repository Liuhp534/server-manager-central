package cn.liuhp.pecs;

import java.util.ArrayList;
import java.util.List;

public class PETest<T> {


    public static void main(String[] args) {
        final Class<List> listClass = List.class;
    }
    /*
    * ? extends T 的使用
    * */
    private static void fun1() {
        List<? extends Fruit> fruits = new ArrayList();
        //fruits.add(new Fruit());//这样的操作是不允许的，有？通配符的情况下
        //fruits.add(new Apple());//这样的操作是不允许的，有？通配符的情况下

        fruits = new ArrayList<Fruit>();
        fruits = new ArrayList<Apple>();
        //fruits = new ArrayList<Food>();//超类不行

        Fruit fruit = fruits.get(0);//但是获取可以确定类型
    }

    /*
    * 参数和返回值写法不同
    * */
    private  <T extends Fruit> T fun2(List<? extends T> fruits) {
        return null;
    }
}
class Food {

}

class Fruit extends Food {

}

class Apple extends Fruit {

}
