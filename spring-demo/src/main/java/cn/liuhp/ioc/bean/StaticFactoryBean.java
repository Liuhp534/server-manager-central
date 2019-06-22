package cn.liuhp.ioc.bean;

/**
 * @description: 静态工厂factoryBean
 * @author: liuhp534
 * @create: 2019-06-22 12:03
 */
public class StaticFactoryBean {


    public static Car initCar() {
        return new Car("Bens", 100);
    }

}
