package cn.eventbus;

import cn.eventbus.event.BaseEvent;
import cn.eventbus.observer.BaseEventObserver;
import com.google.common.eventbus.EventBus;

/*
* 消息的发布，观察者的注册和注销
* */
public class EventBusCenter {

    private static EventBus eventBus = new EventBus();

    public static void register(BaseEventObserver baseEventObserver) {
        eventBus.register(baseEventObserver);
    }

    public static void unregister(BaseEventObserver baseEventObserver) {
        eventBus.unregister(baseEventObserver);
    }

    public static void post(BaseEvent baseEvent) {
        eventBus.post(baseEvent);
    }
}
