package cn.liuhp.list;

/**
 * @description: 外部类包含静态内部类
 * @author: hz16092620
 * @create: 2019-05-06 19:28
 */
public class OuterClass4Static {

    private static String name = "outerName";

    private static String common = "outerClass";

    public static void main(String[] args) {
        InnerClassStatic innerClassStatic = new InnerClassStatic();
        innerClassStatic.m1();
    }

    static class InnerClassStatic {
        private static String common = "innerClass";

        public  void m1() {
            System.out.println(name);//只能访问静态的
            System.out.println(common);//不管是否静态的都会访问内部的
            System.out.println(OuterClass4Static.common);
            //System.out.println(OuterClass4Static.this.common);这个不能访问到，因为含有this，指一个具体的对象
        }
    }
}
