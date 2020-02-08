package cn.liuhp.anno;

import cn.liuhp.anno.aop.AopBusiness;
import cn.liuhp.anno.bean.Food;
import cn.liuhp.anno.bean.Person;
import cn.liuhp.anno.config.AopConfig;
import cn.liuhp.anno.config.ext.BeanFactoryPostConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ApplicationExtMain {

    private static final AnnotationConfigApplicationContext applicationContext;


    static {
        //applicationContext = null;
        applicationContext = new AnnotationConfigApplicationContext(BeanFactoryPostConfig.class);
    }



    public static void main(String[] args) {
        fun1();
    }

    private static void fun1() {
        applicationContext.close();
    }


}
