package cn.liuhp.anno.config;

import cn.liuhp.anno.bean.Person;
import cn.liuhp.anno.condition.WindowCondition;
import cn.liuhp.anno.post.CustomBeanPostProcessor;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = "cn.liuhp.anno")
@Import(Person.class)
public class BeanConfig {


    //@Conditional(value = {WindowCondition.class})
    @Bean(name="john")
    public Person createPerson() {
        return new Person(1, "john");
    }

    @Bean(name="jeff")
    public Person person1() {
        return new Person(2, "jeff");
    }

    @Bean(name="food")
    public FoodFactoryBean createFactoryBean() {
        return new FoodFactoryBean();
    }

    @Bean
    public CustomBeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }
}
