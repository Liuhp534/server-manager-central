package cn.eventbus.observer;

import cn.eventbus.event.DogEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
* 具体的观察者
* */
@Component
public class DogEventEventObserver extends BaseEventObserver<DogEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DogEventEventObserver.class);

    /*
    * 模板方法
    * */
    @Override
    public void handler(DogEvent event) {
        logger.info("DogEventEventObserver...{}", event.getEventName());
    }
}
