package cn.liuhp.anno.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description: 注解版监听器
 * @author: liuhp534
 * @create: 2020-02-07 19:52
 */
@Component
public class AnnotationListener {

    @EventListener({ContextRefreshedEvent.class})
    public void listenerRefreshEvent(ApplicationEvent event) {
        System.out.println("获取注解版的监听器=" + event);
    }


}
