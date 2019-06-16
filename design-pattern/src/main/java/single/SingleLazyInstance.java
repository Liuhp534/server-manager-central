package single;

/**
 * @description: 单例懒汉模式，即初始化的时候不创建
 * @author: liuhp534
 * @create: 2019-06-16 22:03
 */
public class SingleLazyInstance {

    private static SingleLazyInstance singleInstance = null;

    /*构造函数私有化*/
    private SingleLazyInstance() {

    }

    public static SingleLazyInstance getInstance() {
        if (null == singleInstance) {
            synchronized (SingleInstance.class) {
                if (null == singleInstance) {
                    singleInstance = new SingleLazyInstance();
                }
            }
        }
        return singleInstance;
    }
}
