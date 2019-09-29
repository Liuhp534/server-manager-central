package cn.liuhp.core.controller;


import cn.liuhp.base.listener.event.ExecuteEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listener")
public class ListenerController implements ApplicationContextAware {


    private ApplicationContext applicationContext;

    @RequestMapping("/publishExecuteEvent")
    public String publishExecuteEvent(String param) {
        applicationContext.publishEvent(new ExecuteEvent(param));
        return "success";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
