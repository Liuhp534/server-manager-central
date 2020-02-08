package cn.liuhp.anno.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @description: beanfactory后置处理器
 * @author: liuhp534
 * @create: 2020-02-07 14:23
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("进入自定义beanFactoryPostProcessor");
        int beanCount = beanFactory.getBeanDefinitionCount();
        System.out.println("beanCount = " + beanCount);
    }



}
