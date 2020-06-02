package cn.util.file;

public class TestFInal {

    static {
        System.out.println("main static");
    }
    public static void main(String[] args) {
        System.out.println(DogFinal.s1);
    }

}

class DogFinal {
    static {
        System.out.println("static DogFinal");
    }

    public static int i1 = 100;

    public static final int i2 = 200;

    public static final int i3 ;

    static {
        i3 = 300;
    }

    public static final String s1 = "string";

    public static Dog dog1 = new Dog(i1 + "static" + i2);

    public static final Dog dog2 = new Dog(i1 + "static final" + i2);
}
class Dog {

    static {
        System.out.println("static dog");
    }

    Dog (String name) {
        System.out.println("create dog=" + name);
    }
}
