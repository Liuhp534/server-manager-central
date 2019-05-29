package cn.liuhp.math;

import org.junit.Test;

/**
 * @description: 混合运算的规则
 * 混合运算的时候，byte,short,char不会相互转换，都会自动将类型提升为int类型，其他类型进行混合运算时都是将小的数据类型提升为大的
 * byte,short,char ---- int ---- long ---- float ---- double
 * boolean=1bit
 * byte=8bit
 * char=16bit
 * short=16bit
 * int=32bit
 * long=64bit
 * float=32bit
 * double=64bit
 * @author: hz16092620
 * @create: 2019-04-12 15:02
 */
public class MixOperation {

    public static void main(String[] args) {
        //m1();
        //m2();
        m3();
        //m4();
        //m5();
    }

    private static void m6() {
        int i1 = 100;
        byte b1 = 100;
        Byte b2 = new Byte(b1);
        System.out.println(Integer.valueOf(b1));//说明可以自动转int
        System.out.println(Integer.valueOf(b2));
        //System.out.println(Byte.valueOf(1000));//报错
        System.out.println(Byte.valueOf(i1 + ""));//转为字符串
    }
    /*字符串和数字进行拼接，负数的话负数的符号依然保留*/
    private static void m5() {
        System.out.println("name" + -1);
        System.out.println("name" + 1);
        System.out.println("name" + +1);
        int i1 = -1;
        System.out.println("name" + ++ i1);//这里涉及到运算顺序的问题
        System.out.println(1 + 1 + "name");//顺序问题 从左到右执行
    }

    /*java的基本数据类型中，boolean只有两种状态，默认值为false.取值范围是{true,false}，理论上占1bit，实际上：
    1.单个的boolean 类型变量在编译的时候是使用的int 类型。
    boolean a=true;//这个a在JVM中占4个字节即：32位。 处理器（CPU）对于32位具有高效存取的特点
    2.boolean 类型的数组时，在编译的时候是作为byte array来编译的所以boolean 数组里面的每一个元件占一个字节，
    boolean[] b = new boolean[10];//数组时，每一个boolean在JVM中占一个字节。
    */
    private static void m4() {
        boolean b1 = true;
        Boolean b2 = new Boolean(true);
        Boolean b3 = true;
        Boolean[] b4s = {true};
        System.out.println((b1 + "").length());
        System.out.println(b2.toString().length());
        System.out.println(b3.toString().length());
        System.out.println(b4s[0].toString().length());
    }

    /*Integer比较，Byte的比较
     * 总结：和常量比较不需要intValue这样的方法也行，会自动拆箱
     * */
    @Test
    public static void m3() {
        Integer i1 = 200;
        Integer i2 = new Integer(200);
        Integer i3 = 100;
        Integer i4 = new Integer(100);
        Integer i5 = 100;
        int i6 = 100;
        System.out.println(i3 == i5);//true
        System.out.println(i3 == i4);//false-128到127Integer会作为常量缓存，如果new了就是新对象
        System.out.println(i4 == 100);//true常量对比
        System.out.println(i4 == i6);//true常量对比
        System.out.println(i4.intValue() == 100);//true
        Integer i7 = null;
        System.out.println(i7 == 100);//会报错
        System.out.println("--------------------------------byte------------------------");
        Byte b1 = 100;
        Byte b2 = new Byte((byte) 100);
        Byte b3 = 100;
        Byte b4 = (byte) 200;
        Byte b5 = new Byte((byte) 200);
        byte b6 = 100;
        System.out.println(b1 == b3);//true 有缓存
        System.out.println(b1 == b2);//false 不同的对象
        System.out.println(b3 == b6);//true 转换为int再运算
        System.out.println(b3 == 100);//true 转换为int再运算
        System.out.println(i4 == b6);//true 转换为int再运算，i4拆箱成int
        Byte b7 = -128;
        Byte b8 = -128;
        System.out.println(b4);//超出范围数字会变
        System.out.println(b7 == b8);//true -128到127
    }

    /*计算会向上转换*/
    private static void m2() {
        byte b1 = 1;
        byte b2 = 2;
        //byte b3 = b1 + b2;会编译报错，b1和b2计算的时候往上转型也就是int，加完之后是int类型不会自动转byte
        byte b4 = 0;
        b4++;//做了优化
        b4 += 1;//做了优化
        System.out.println(b4);
        /*
          1、byte与byte（或者short、char）进行运算的时候会提升为int
          2、b1和b2是两个变量，变量存储的值是变化的，在编译时候无法判断里面具体的值，相加有可能超出byte的值范围
        */
        byte b5 = 1 + 2;     //java编译器常量优化机制
        byte b6 = 3;
        System.out.println(b5);
        System.out.println(b6);
        byte b7 = 1;
        short s1 = 1;
        short s2 = (short) (b7 + s1);//b7和s1自动转换为int
        System.out.println(s2);
    }

    /*float取值范围比long更大
     * float 4个字节 long 8个字节，但是取值更大，参考：https://blog.csdn.net/u011240877/article/details/47723263
     * */
    private static void m1() {
        float f = 12.0F;
        long l = 88897382L;

        f = l;
        System.out.println(f);//long转float精度不会丢失

        l = (long) f;
        System.out.println(l);//精度丢失
    }
}
