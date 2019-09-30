package cn.eventbus.event;

import lombok.Data;

@Data
public class PersonEvent implements BaseEvent {

    private String eventName = BaseEvent.class.getSimpleName();

}
