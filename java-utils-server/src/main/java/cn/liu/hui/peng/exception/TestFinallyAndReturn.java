package cn.liu.hui.peng.exception;

/**
 * @description: return和finally返回值问题
 * @author: hz16092620
 * @create: 2019-07-18 09:51
 */
public class TestFinallyAndReturn {


    public static void main(String[] args) {
        System.out.println(fun1());
    }


    /*
    * 返回的的是finally块的内容
    * */
    private static String fun1() {
        String result = "";
        int age = 100;
        try {
            if (age > 100) {
                result = "老年人";
                return result;
            } else {
                result = "正常人";
                return result;
            }
        } finally {
            return  "finally";
        }
    }
}
