package cn.liuhp.base.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*
 * 这个是没有泛型的，看看能够执行几次 or 只是ApplicationEvent都会执行多次（3次）
 * */
@Component
public class SpringListenerTest implements ApplicationListener {

    private static final Logger logger = LoggerFactory.getLogger(SpringListenerTest.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("无泛型的springlistener。。。。。。  {}", event.getClass());
    }
}
