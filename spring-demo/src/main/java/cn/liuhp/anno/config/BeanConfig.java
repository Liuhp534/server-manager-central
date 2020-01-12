package cn.liuhp.anno.config;

import cn.liuhp.anno.bean.Person;
import cn.liuhp.anno.condition.WindowCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "cn.liuhp.anno")
public class BeanConfig {


    @Conditional(value = {WindowCondition.class})
    @Bean(name="john")
    public Person createPerson() {
        return new Person(1, "john");
    }

    @Bean(name="jeff")
    public Person person1() {
        return new Person(2, "jeff");
    }
}
