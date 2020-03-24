package cn.liuhp.extend;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-18 16:28
 */
public class TestSuperAndThis {

    public static void main(String[] args) {
        fun1();
    }


    /*
    * 印证了，就是说父类和子类都有一个name，只设置父类的，子类的还是原来的
    * */
    private static void fun1() {
        Student student = new Student("superName");

        System.out.println(student.name);
    }

}


class Person {

    protected String name;

    public Person () {

    }

}

class Student extends Person {

    protected String name;

    public Student (String superName) {
        super.name = superName;
    }
}
