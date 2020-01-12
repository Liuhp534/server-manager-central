package cn.liuhp.anno;

import cn.liuhp.anno.bean.Person;
import cn.liuhp.anno.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class ApplicationMain {

    public static void main(String[] args) {
        fun1();
    }


    /*
    * AnnotationConfigApplicationContext 容器的使用
    * */
    private static void fun1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
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
