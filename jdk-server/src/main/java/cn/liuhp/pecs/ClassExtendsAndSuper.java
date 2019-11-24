package cn.liuhp.pecs;

public class ClassExtendsAndSuper {



    /*
    * 根据类的泛型的定义，来限制T的类型
    * person的定义
    * class Person implements Comparable
    * */
    private static void fun1() {
        Test1<Person> test1 = new Test1<>();
        Test1<NorthPerson> test2 = new Test1<>();
    }

    /*
     * 根据类的泛型的定义，来限制T的类型
     * person的定义
     * class Person implements Comparable<Person>
     * */
    private static void fun2() {
        Test2<Person> test1 = new Test2<>();
        //Test2<NorthPerson> test2 = new Test2<>();//关键就是这里NorthPerson没有实现Comparable<NorthPerson> 只是父类实现了，加个? super T就ok了
    }

    /*
     * 根据类的泛型的定义，来限制T的类型
     * person的定义
     * class Person implements Comparable<Person>
     * */
    private static void fun3() {
        Test3<Person> test1 = new Test3<>();
        Test3<NorthPerson> test2 = new Test3<>();//关键就是这里NorthPerson没有实现Comparable<NorthPerson> 只是父类实现了，加个? super T就ok了
    }

}

class Test1<T extends Comparable> {

}
class Test2<T extends Comparable<T>> {

}
class Test3<T extends Comparable<? super T>> {

}

class Person implements Comparable<Person> {

    int height;

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

class NorthPerson extends Person {



}
