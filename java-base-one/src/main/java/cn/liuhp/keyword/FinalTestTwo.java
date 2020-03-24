package cn.liuhp.keyword;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-22 14:50
 */
public class FinalTestTwo {

    private static final FinalDog staticFinalDog = new FinalDog("static final");

    public final FinalDog finalDog = new FinalDog("final");//需要显示的初始化，单例当中使用final与否没有太大的关系

    public static void main(String[] args) {

    }

}

class FinalDog {

    public FinalDog (String name) {
        System.out.println("create FinalDog=" + name);
    }
}
