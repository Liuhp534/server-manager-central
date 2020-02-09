package cn.liuhp.anno.listener;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: 监听器
 * @author: liuhp534
 * @create: 2020-02-07 15:12
 */
@Component
public class SpringListener implements ApplicationListener<ApplicationEvent>, InitializingBean {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件=" + event.toString());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化方法。。。");
    }
}
