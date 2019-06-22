package cn.liuhp.ioc.prepare;

import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.beans.PropertyEditor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 第一阶段
 * @author: liuhp534
 * @create: 2019-06-22 16:13
 */
public class BeanFactoryPrepare {

    public static void main(String[] args) {
        //test1();
        test2();
    }


    /*测试PropertyPlaceholderConfigurer*/
    private static void test1() {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        PropertyPlaceholderConfigurer placeholderConfigurerPostProcessor = new PropertyPlaceholderConfigurer();
        placeholderConfigurerPostProcessor.setLocation(new ClassPathResource("config.properties"));

        placeholderConfigurerPostProcessor.postProcessBeanFactory(beanFactory);
        //PropertyOverrideConfigurer 会替换掉name
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        propertyOverrideConfigurer.setLocation(new ClassPathResource("overrideConfig.properties"));

        propertyOverrideConfigurer.postProcessBeanFactory(beanFactory);
        Dog dog = (Dog) beanFactory.getBean("dog");
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
    }

    /*自定义类型转换器*/
    private static void test2() {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        PropertyPlaceholderConfigurer placeholderConfigurerPostProcessor = new PropertyPlaceholderConfigurer();
        placeholderConfigurerPostProcessor.setLocation(new ClassPathResource("config.properties"));
        placeholderConfigurerPostProcessor.postProcessBeanFactory(beanFactory);

        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map map = new HashMap<>();
        map.put(Date.class, DatePropertyEditor.class);
        customEditorConfigurer.setCustomEditors(map);
        customEditorConfigurer.postProcessBeanFactory(beanFactory);

        //通过beanpostprocessor修改name
        beanFactory.addBeanPostProcessor(new UpdateNameBeanPostProcessor());//applicationContext可以直接配置
        Dog dog = (Dog) beanFactory.getBean("dog");
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
        System.out.println(dog.getBirthday());

        //定义了销毁方法，不会执行需要执行下面的方法
        beanFactory.destroySingletons();
    }

}
