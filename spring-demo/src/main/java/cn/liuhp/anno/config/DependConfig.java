package cn.liuhp.anno.config;

import cn.liuhp.anno.aop.AopAspect;
import cn.liuhp.anno.aop.AopBusiness;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScans({@ComponentScan("cn.liuhp.anno.bean")})
public class DependConfig {


    @Bean
    @Lazy
    public AopBusiness aopBusiness() {
        return new AopBusiness();
    }
}
