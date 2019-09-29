package cn.liuhp.base.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/*
* 在IOC的容器的启动过程，当所有的bean都已经处理完成之后，spring ioc容器会有一个发布事件的动作
* 也给我们提供了一个机会（先有InitializingBean，后有ApplicationListener<ContextRefreshedEvent>），可以去做一些自己想做的事。
* 其实这也就是spring ioc容器给提供的一个扩展的地方
* */
@Component
public class InitApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(InitApplicationListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("ContextRefreshedEvent 事件，执行监听器。。。");
    }
}
