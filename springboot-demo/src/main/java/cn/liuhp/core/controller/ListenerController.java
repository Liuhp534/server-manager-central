package cn.liuhp.core.controller;


import cn.liuhp.base.listener.InitApplicationListener;
import cn.liuhp.base.listener.event.ExecuteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/listener")
public class ListenerController implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ListenerController.class);

    private ApplicationContext applicationContext;

    @RequestMapping("/publishExecuteEvent")
    public String publishExecuteEvent(String param) {
        applicationContext.publishEvent(new ExecuteEvent(param == null ? "defaultExecuteEvent" : param));
        return "success";
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
