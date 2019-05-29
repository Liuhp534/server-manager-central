package cn.liuhp.list;

/**
 * @description: 外部类测试，同一个包内
 * @author: hz16092620
 * @create: 2019-05-06 16:40
 */
public class OuterClassTest {

    public static void main(String[] args) {
    }

    private static void m3() {
        // 初始化Bean1
        TestOuterAndInner outer = new TestOuterAndInner();
        TestOuterAndInner.Bean1 bean1 = outer.new Bean1();//这里需要TestOuterAndInner.；同样的Bean1如果private修饰那么不能访问。
        bean1.I++;
        bean1.hello();
    }

    /*测试内外部类*/
    private static void m1() {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();//default包访问权限可以
        inner.im1();//需要default|protected
    }
}
