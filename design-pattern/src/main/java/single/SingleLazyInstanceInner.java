package single;

/**
 * @description:
 * 静态内部类和非静态内部类一样，都不会因为外部类的加载而加载，
 * 外部类先加载，内部类后加载的顺序
 * @author: liuhp534
 * @create: 2020-03-22 14:57
 */
public class SingleLazyInstanceInner {

    public static void main(String[] args) {
        System.out.println(CreateInstanceClass.i);
        //getInstance();
    }
    private static class CreateInstanceClass {
        private static int i = 100;

        static {
            System.out.println("CreateInstanceClass类加载");
        }

        private static SingleLazyInstanceInner singleInstance = new SingleLazyInstanceInner();
    }

    static {
        System.out.println("SingleLazyInstanceInner类加载");
    }
    /*构造函数私有化*/
    private SingleLazyInstanceInner() {
        System.out.println("create SingleLazyInstanceInner");
    }

    public static SingleLazyInstanceInner getInstance() {
        return CreateInstanceClass.singleInstance;
    }


}
