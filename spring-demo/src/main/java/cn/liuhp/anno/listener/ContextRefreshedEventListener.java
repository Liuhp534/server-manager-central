package cn.liuhp.anno.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @description: 所有bean创建完成事件
 * @author: liuhp534
 * @create: 2020-02-07 15:35
 */
@Component
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("所有bean创建完成，后续处理程序");
    }
}
