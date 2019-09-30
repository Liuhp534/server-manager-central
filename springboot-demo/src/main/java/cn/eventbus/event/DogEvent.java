package cn.eventbus.event;

import lombok.Data;

@Data
public class DogEvent implements BaseEvent {


    private String eventName = BaseEvent.class.getSimpleName();
}
