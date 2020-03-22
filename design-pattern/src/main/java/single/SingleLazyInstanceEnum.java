package single;

/**
 * @description:
 * 静态内部类和非静态内部类一样，都不会因为外部类的加载而加载，
 * 外部类先加载，内部类后加载的顺序
 * @author: liuhp534
 * @create: 2020-03-22 14:57
 */
public class SingleLazyInstanceEnum {

    static {
        System.out.println("SingleLazyInstanceEnum类加载");
    }

    public static void main(String[] args) {
        CreateInstanceEnum.SINGLE.getInstance();
    }

    private enum CreateInstanceEnum {

        SINGLE;

        static {
            System.out.println("CreateInstanceEnum类加载");
        }

        private SingleLazyInstanceEnum instanceEnum;

        CreateInstanceEnum() {
            instanceEnum = new SingleLazyInstanceEnum();
        }

        private SingleLazyInstanceEnum getInstance() {
            return instanceEnum;
        }
    }

    private SingleLazyInstanceEnum() {
        System.out.println("create SingleLazyInstanceEnum");
    }

}


