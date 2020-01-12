package cn.liuhp.anno.config;

import cn.liuhp.anno.bean.Food;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
/*
* 用于创建bean
* */
@Data
public class FoodFactoryBean implements FactoryBean<Food> {

    @Override
    public Food getObject() throws Exception {
        return new Food();
    }

    @Override
    public Class<?> getObjectType() {
        return Food.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
