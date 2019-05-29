package java.lang;

/**
 * @description: 双亲委派类
 * @author: hz16092620
 * @create: 2019-04-26 15:28
 */
public class String {

    static {
        System.out.println("static ");
    }

    public static void main(String[] args) {
        String str = new String();
        System.out.println(str);
    }
}
