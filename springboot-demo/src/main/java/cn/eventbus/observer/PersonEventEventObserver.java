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
        int i = 0;
        logger.info("PersonEventObserver...{}", event.getEventName());
        /*if (i==0) {
            throw new RuntimeException("人为抛出。，。");
        }*/
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
