package cn.liuhp.anno;

import cn.liuhp.anno.aop.AopBusiness;
import cn.liuhp.anno.bean.Food;
import cn.liuhp.anno.bean.Person;
import cn.liuhp.anno.config.AopConfig;
import cn.liuhp.anno.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class ApplicationMain {

    private static final ApplicationContext applicationContext;

    private static final ApplicationContext applicationContextAop;

    static {
        applicationContext = null;
        //applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        //applicationContextAop = null;
        applicationContextAop = new AnnotationConfigApplicationContext(AopConfig.class);
    }



    public static void main(String[] args) {
        //fun1();
        //fun2();
        fun4();
    }

    /*
    * aop
    * */
    private static void fun4() {
        AopBusiness aopBusiness = applicationContextAop.getBean(AopBusiness.class);
        System.out.println(aopBusiness.toString());
        System.out.println(aopBusiness.getClass().toString());
        System.out.println(aopBusiness.getClass().getClassLoader());
        Integer result1 = aopBusiness.add(1, 1);
        Integer result = aopBusiness.calculate(1, 1);
        System.out.println(result);
    }

    /*
    * 加入aware的配置？？？？
    * */
    private static void fun3() {

    }

    private static void fun2() {
        String[] personNames = applicationContext.getBeanNamesForType(Food.class);
        System.out.println("beanNames : " + Arrays.toString(personNames));
        //根据类型获取
        Object food = applicationContext.getBean(Food.class);
        System.out.println(food);
        food = applicationContext.getBean("&food");
        System.out.println(food);
    }
    /*
    * AnnotationConfigApplicationContext 容器的使用
    * */
    private static void fun1() {

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("beanDefinitionNames : " + beanName);
        }
        //根据类型获取
        /*Person person = (Person) applicationContext.getBean(Person.class);
        System.out.println(person);*/
        String[] personNames = applicationContext.getBeanNamesForType(Person.class);
        System.out.println("beanNames : " + Arrays.toString(personNames));
    }
}
