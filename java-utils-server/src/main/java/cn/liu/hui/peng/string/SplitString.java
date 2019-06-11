package cn.liu.hui.peng.string;

import java.util.Arrays;

/**
 * @description: 分隔字符串的demo
 * @author: hz16092620
 * @create: 2019-06-11 09:36
 */
public class SplitString {


    public static void main(String[] args) {
        test1();
    }

    /*split的使用*/
    private static void test1() {
        //"" =1
        String str = "";
        String[] arr = str.split("\\|");
        System.out.println(arr.length);
        //"|"=0
        str = "|";
        arr = str.split("\\|");
        System.out.println(arr.length);
        //"a|" =1
        str = "a|";
        arr = str.split("\\|");
        System.out.println(arr.length);
        //"|a"=2
        str = "|a";
        arr = str.split("\\|");
        System.out.println(arr.length);
    }
}
