package cn.eventbus;


import cn.eventbus.observer.BaseEventObserver;
import cn.eventbus.observer.DogEventEventObserver;
import cn.eventbus.observer.PersonEventEventObserver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/*
* 观察者的注册
* */
@Configuration
public class EventBusConfiguration implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, BaseEventObserver> beans = applicationContext.getBeansOfType(BaseEventObserver.class);
        if (!CollectionUtils.isEmpty(beans)) {
            for (BaseEventObserver bean : beans.values()) {
                EventBusCenter.register(bean);
            }
        }
    }
}
