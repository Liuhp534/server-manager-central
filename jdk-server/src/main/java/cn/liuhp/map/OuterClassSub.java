package cn.liuhp.map;

import cn.liuhp.list.InnerClassInterface;
import cn.liuhp.list.OuterClass;

/**
 * @description: 外部类之类
 * @author: hz16092620
 * @create: 2019-05-06 16:44
 */
public class OuterClassSub extends OuterClass {

    public static void main(String[] args) {
        //m2();
        m1();
    }

    private  static void m1() {
        OuterClassSub outSub = new OuterClassSub();
        outSub.getInner().im1();//父类方法protected
        outSub.new InnerClass().im1();
        System.out.println("-----------------");
        OuterClass out = new OuterClassSub();
        out.new InnerClass().im1();//也就是说子类能够继承，但是修复符要是public，
    }

    /*测试继承
    * 内部类哪个类调用的就会调哪个类里面的，不存在多态，多态是对于方法的。
    * */
    private static void m2() {
        OuterClass out = new OuterClassSub();
        OuterClassSub outSub = new OuterClassSub();
        outSub.getInner().im1();//父类方法protected
        System.out.println("--------------------");
        out.new InnerClass().im1();//也就是说子类能够继承，但是修复符要是public
        System.out.println("--------------------");
        //System.out.println(out.protectedPro);//父类属性protected，这里为什么报错呢？？？？
        System.out.println(outSub.protectedPro);//父类属性protected
        System.out.println("--------------------");
        outSub.new InnerClass().im1();//这个是子类的同名内部类
    }

    /*非静态类创建*//*
    public InnerClassInterface getInner() {
        return new InnerClass();
    }

    *//*内部类没有多态的*//*
    protected class InnerClass implements InnerClassInterface  {
        private String common = "innerCommon";//都有的属性

        public void im1() {
            System.out.println(common);//可以直接使用
        }
    }*/


    /*测试内外部类*/
    /*private static void m1() {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();//default包访问权限，外部包子类也不能访问，需要protected
        inner.im1();//需要default|protected
    }*/
}
