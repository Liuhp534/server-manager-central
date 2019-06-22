package cn.liuhp.ioc.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @description: 自定义factorybean
 * @author: liuhp534
 * @create: 2019-06-22 15:43
 */
public class CustomCarFactoryBean implements FactoryBean<Car> {

    @Override
    public Car getObject() throws Exception {
        return new Car("come from customCarFacotry...", 1000);
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
