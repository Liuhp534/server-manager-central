package cn.liuhp.base.listener.event;

import org.springframework.context.ApplicationEvent;

/*
* 自定义事件的消息
* */
public class ExecuteEvent extends ApplicationEvent {


    public ExecuteEvent(String source) {
        super(source);
    }




}
