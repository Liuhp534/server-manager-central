package cn.liuhp.jvm;

/**
 * a、父类的静态代码块/类静态变量->子类的静态代码块/类静态变量->
 * b、初始化父类的属性值/父类的普通代码块(自上而下的顺序排列)->父类的构造方法->
 * c、初始化子类的属性值/子类的普通代码块(自上而下的顺序排列)->子类的构造方法
 * @description:
 * @author: liuhp534
 * @create: 2020-03-13 15:12
 */
public class FinalTest {

    private final TestFFF testFFF = new TestFFF("常量对象");

    private static final TestFFF testFFF3 = new TestFFF("静态对象2");//这个是常量
    static {
        System.out.println("FinalTest静态块");
    }
    private static TestFFF testFFF2 = new TestFFF("静态对象");
    static {
        System.out.println("FinalTest静态块2");
    }

    static {
        System.out.println("FinalTest静态块3");
    }

    public FinalTest() {
        System.out.println("创建FinalTest");
    }
    {
        System.out.println("FinalTest实体块");
    }
    public static void main(String[] args) {
        FinalTest test = new FinalTest();
    }


}


class TestFFF {

    public TestFFF (String msg) {
        System.out.println(msg);
    }


}
