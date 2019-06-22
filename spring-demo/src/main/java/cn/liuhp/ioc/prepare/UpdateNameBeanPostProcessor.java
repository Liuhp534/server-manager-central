package cn.liuhp.ioc.prepare;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @description: 自定义beanpostprocessor
 * @author: liuhp534
 * @create: 2019-06-22 19:57
 */
public class UpdateNameBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o instanceof Dog) {//修改dog的名字
            ((Dog) o).setName("beanpostprocessor name...");
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
