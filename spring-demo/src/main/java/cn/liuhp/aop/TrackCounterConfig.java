package cn.liuhp.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description: bean配置类
 * @author: hz16092620
 * @create: 2019-06-13 16:13
 */
@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public BlackDisc configBlackDisc() {
        return new BlackDisc();
    }

    @Bean
    public BlackDiscAspect configBlackDiscAspect() {
        return new BlackDiscAspect();
    }

}
