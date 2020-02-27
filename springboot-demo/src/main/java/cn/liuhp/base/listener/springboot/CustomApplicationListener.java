package cn.liuhp.base.listener.springboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @description: 这个监听器就是不用创建，springboot扩展创建
 * @author: liuhp534
 * @create: 2020-02-27 14:11
 */
public class CustomApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("=========这个监听器就是不用创建，springboot扩展创建======");
    }

}
