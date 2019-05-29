package cn.liuhp.list;

/**
 * @description: 内部外部类测试
 * 创建静态内部类对象的一般形式为：  外部类类名.内部类类名 xxx = new 外部类类名.内部类类名()
 *
 * 创建成员内部类对象的一般形式为：  外部类类名.内部类类名 xxx = 外部类对象名.new 内部类类名()
 * @author: hz16092620
 * @create: 2019-05-13 14:09
 */
public class TestOuterAndInner {
    public static void main(String[] args){
        // 初始化Bean1
        TestOuterAndInner outer = new TestOuterAndInner();
        TestOuterAndInner.Bean1 bean1 = outer.new Bean1();//这里可以不需要TestOuterAndInner.
        bean1.I++;
        bean1.hello();
        // 初始化Bean2
        TestOuterAndInner.Bean2 bean2 = new TestOuterAndInner.Bean2();//静态内部类加上两个TestOuterAndInner. 也行，主要是为了更好阅读
        bean2.J++;
        //初始化Bean3
        Bean bean = new Bean();
        Bean.Bean3 bean3 = bean.new Bean3();//这里需要Bean.
        bean3.k++;
        //初始化bean4
        Bean.Bean4 bean4 = new Bean.Bean4();
    }
     class Bean1{//这里是private那么外部不能使用，只能内部使用
        public int I = 0;

        public String hello() {
            return "hello";
        }
    }

    static class Bean2{
        public int J = 0;
    }
}
class Bean{
    class Bean3{
        public int k = 0;
    }
    static class Bean4 {

    }
}

