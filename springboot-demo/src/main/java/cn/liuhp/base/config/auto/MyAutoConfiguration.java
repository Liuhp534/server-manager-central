package cn.liuhp.base.config.auto;

import cn.liuhp.base.config.ConfigurationPropertiesTest;
import cn.liuhp.utils.JackJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 自定义自动配置类
 * @author: liuhp534
 * @create: 2020-02-23 10:31
 */
@Configuration//表明是注解类
@EnableConfigurationProperties(MyAutoConfigurationProperties.class)
public class MyAutoConfiguration {

    private  MyAutoConfigurationProperties myAutoConfigurationProperties;//这个不能通过set注入，通过构造函数

    public MyAutoConfiguration (MyAutoConfigurationProperties _myAutoConfigurationProperties) {
        this.myAutoConfigurationProperties = _myAutoConfigurationProperties;
        System.out.println("MyAutoConfiguration print " + JackJsonUtils.beanToJson(myAutoConfigurationProperties));
    }

    @Bean
    public Object createObject(MyAutoConfigurationProperties _myAutoConfigurationProperties) {
        System.out.println("Object print " + JackJsonUtils.beanToJson(_myAutoConfigurationProperties));
        return new Object();
    }


}
