package decorator;

import java.io.*;
import java.net.URL;

public class DecoratorMain {


    public static void main(String[] args) {
        //fun1();
        fun2();
    }


    /*
    * 实现转换小写的装饰类
    * */
    private static void fun1() {
        try {
            InputStream input = DecoratorMain.class.getClassLoader().getResourceAsStream("decorator.text");// 获取文件的输入流
            input = new LowerCaseInputStream(input);
            int result = -1;
            while ((result = input.read()) != -1) {
                System.out.print((char)result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    * 一个快速的人跑，邦着沙袋，沙袋就是装饰
    * */
    private static void fun2() {
        Person person = new FastPerson();
        person = new WeightDecorator(person);

        System.out.println(person.run());
    }
}
