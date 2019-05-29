package cn.liuhp.list;

/**
 * @description: 外部类
 * @author: hz16092620
 * @create: 2019-05-06 16:25
 */
public class OuterClass {

    private String name = "outer";//成员变量

    private static int age = 10;//静态成员变量

    private String common = "outerCommon";//都有的属性

    protected String protectedPro = "outerProteced";//继承访问权限

    public static void main(String[] args) {
        m1();
    }

    /*测试内外部类*/
    private static void m1() {
        OuterClass outer = new OuterClass();
        InnerClass inner = outer.new InnerClass();
        inner.im1();
        outer.protectedPro ="";
    }

    /*非静态类创建*/
    public  InnerClassInterface getInner() {
        return new InnerClass();
    }

    /*非static成员内部类
    * 1、创建必须有外部类实例m1()
    * 2、getInner()
    * 可以有private、protected、default、public 修饰
    * */
    public class InnerClass implements InnerClassInterface  {
        private String common = "innerCommon";//都有的属性

        public void im1() {
            System.out.println(name);//可以直接使用
            System.out.println(age);//可以直接使用
            System.out.println(common);//可以直接使用
            System.out.println(OuterClass.this.common);//同名的需要：外部类名.this.属性/方法
            System.out.println(OuterClass.this.age);//同名的需要：外部类名.this.属性/方法
        }
    }
}
