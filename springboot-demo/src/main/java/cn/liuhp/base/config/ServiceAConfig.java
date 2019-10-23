package cn.liuhp.base.config;

import cn.liuhp.core.service.impl.ServiceAImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAConfig {



    /*
    * 通过javaconfig配置bean服务，然后B去使用
    * */
    /*@Bean
    public ServiceAImpl serviceA() {
        return new ServiceAImpl();
    }*/
}
