package cn.liuhp.ioc.prepare;

import cn.liuhp.ioc.bean.Person;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        //test2();
        test3();
        //test4();
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

    /*通过autowired*/
    private static void test3() {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactory.xml"));

        beanFactory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());
        beanFactory.getBean("car1");
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

    }

    /*通过autowired*/
    private static void test4() {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("beanFactory.xml");
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

    }
}
