package cn.liuhp.anno.config;

import cn.liuhp.anno.aop.AopAspect;
import cn.liuhp.anno.aop.AopBusiness;
import cn.liuhp.anno.aop.LogAopAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public AopAspect aopAspect() {
        return new AopAspect();
    }

   /* @Bean
    public LogAopAspect logAopAspect() {
        return new LogAopAspect();
    }*/

    @Bean
    public AopBusiness aopBusiness() {
        return new AopBusiness();
    }
}
