package cn.liuhp.anno;

import cn.liuhp.anno.config.DependConfig;
import cn.liuhp.anno.config.ext.BeanFactoryPostConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationDependMain {

    private static final AnnotationConfigApplicationContext applicationContext;


    static {
        //applicationContext = null;
        applicationContext = new AnnotationConfigApplicationContext(DependConfig.class);
    }



    public static void main(String[] args) {
        fun1();
    }

    private static void fun1() {
        applicationContext.close();
    }


}
