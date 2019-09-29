package cn.liuhp.base.listener;

import cn.liuhp.base.listener.event.ExecuteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener implements ApplicationListener<ExecuteEvent> {


    private static final Logger logger = LoggerFactory.getLogger(CustomEventListener.class);

    @Override
    public void onApplicationEvent(ExecuteEvent executeEvent) {
        Object eventParam = executeEvent.getSource();
        if (eventParam instanceof String) {
            logger.info("执行自定义事件消息ExecuteEvent的监听，param={}", eventParam);
        }
    }
}
