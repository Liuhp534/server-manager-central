package single;

/**
 * @description: 单例饿汉模式，即初始化的时候创建
 * @author: liuhp534
 * @create: 2019-06-16 22:03
 */
public class SingleInstance {

    private static  final SingleInstance singleInstance = new SingleInstance();//final思考一下可以用不

    /*构造函数私有化*/
    private SingleInstance() {

    }

    public static SingleInstance getInstance() {
        return singleInstance;
    }
}

class SingleInstanceTwo {

    private SingleInstanceTwo() {

    }

    private static  final SingleInstanceTwo singleInstance;

    static {
        singleInstance = new SingleInstanceTwo();
    }
}
