package cn.liuhp.anno.bean;

import cn.liuhp.anno.aop.AopBusiness;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Data
@Component
//@DependsOn("aopBusiness")
public class Food implements BeanFactoryAware, ApplicationContextAware, InitializingBean {

    @Autowired
    private AopBusiness aopBusiness;

    private ApplicationContext applicationContext;


    public Food () {
        System.out.println("Food 创建");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("获取beanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("获取applicationContext");
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("aopBusiness=" + aopBusiness);
    }
}
