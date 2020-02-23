package cn.liuhp.domain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

/**
 * @description: 非web环境下的bean
 * @author: liuhp534
 * @create: 2020-02-23 14:45
 */
@ConditionalOnNotWebApplication//可以实现，在组件上
@Component
public class NotWebBean {


    public NotWebBean() {
        System.out.println("NotWebBean create.");
    }

}
