package cn.liuhp.base.config;


import cn.liuhp.core.service.impl.ServiceAImpl;
import cn.liuhp.core.service.impl.ServiceBImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceAImpl.class)
//@Conditional(ServiceBCondition.class)
@EnableConfigurationProperties(ConfigurationPropertiesTest.class)//不清楚为什么这个不起作用
public class ServiceBConfig {

    /*@Autowired
    private ConfigTest configTest;*/

    @Bean
    public ServiceBImpl serviceB(ServiceAImpl serviceA) {
        serviceA.service();
        //System.out.println(configTest.getLikes().toString());
        return new ServiceBImpl();
    }

}
