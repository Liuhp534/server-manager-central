package cn.liuhp.ioc.prepare;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Date;

/**
 * @description: 狗
 * @author: liuhp534
 * @create: 2019-06-22 16:15
 */
public class Dog implements InitializingBean, DisposableBean {

    private String name;

    private int age;

    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("dog name : " + this.name);
        System.out.println("在beanpostprocessor做一些事情");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁前做一些事情。。。");
    }
}
