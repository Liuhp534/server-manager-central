package cn.liuhp.ioc.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 启动服务类
 * @author: liuhp534
 * @create: 2019-06-09 12:01
 */
public class SpringDemoServer {

    public static void main(String[] args) {
        //创建spring容器
        //1、ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2、从ioc容器中获取组件
        //HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");//通过id注入
        HelloSpring helloSpring = applicationContext.getBean(HelloSpring.class);//通过类型注入
        helloSpring.sayHello();

        //3、这个时候没有无参数的构造函数
        Car car1 = (Car) applicationContext.getBean("car1");
        System.out.println(car1);
        Car car2 = (Car) applicationContext.getBean("car2");
        System.out.println(car2);

        //4、依赖其他bean的bean
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
