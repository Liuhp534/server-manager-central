package cn.eventbus.observer;

import cn.eventbus.event.PersonEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PersonEventEventObserver extends BaseEventObserver<PersonEvent> {

    private static final Logger logger = LoggerFactory.getLogger(PersonEventEventObserver.class);


    @Override
    public void handler(PersonEvent event) {
        logger.info("PersonEventObserver...{}", event.getEventName());
    }
}
