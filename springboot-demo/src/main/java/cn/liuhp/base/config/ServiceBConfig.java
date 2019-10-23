package cn.liuhp.base.config;


import cn.liuhp.base.condition.ServiceBCondition;
import cn.liuhp.core.service.impl.ServiceAImpl;
import cn.liuhp.core.service.impl.ServiceBImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceAImpl.class)
@Conditional(ServiceBCondition.class)
public class ServiceBConfig {


    @Bean
    public ServiceBImpl serviceB(ServiceAImpl serviceA) {
        serviceA.service();
        return new ServiceBImpl();
    }

}
