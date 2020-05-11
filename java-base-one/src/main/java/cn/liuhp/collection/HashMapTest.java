package cn.liuhp.collection;

public class HashMapTest {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //fun1();
        //fun2();
        System.out.println(System.currentTimeMillis() - start);
        //fun3();
        fun4();
    }

    /*
    * 最大的值
    * */
    private static void fun4() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    private static void fun1() {
        int index;
        for (int i=0; i < 10000000; i++) {
            index = "20200410002190".hashCode() % 30;
        }

    }

    private static void fun2() {
        int index;
        for (int i=0; i < 10000000; i++) {
            index = "20200410002190".hashCode();
            index = index ^ (index >>> 16);
            index = index & 29;
        }
    }

    private static void fun3() {
        int hashCode = "20200410002190".hashCode();
        System.out.println(hashCode % 32);
        hashCode = hashCode ^ (hashCode >>> 16);//融合高低16位的特征

        System.out.println(hashCode % 32);
        System.out.println(hashCode & 31);

        System.out.println(hashCode % 64);
        System.out.println(hashCode & 63);
    }
}
