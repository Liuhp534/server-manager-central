package cn.liuhp.core.controller;

import cn.eventbus.EventBusCenter;
import cn.eventbus.event.BaseEvent;
import cn.eventbus.event.DogEvent;
import cn.eventbus.event.PersonEvent;
import cn.liuhp.base.config.ConfigTest;
import cn.liuhp.base.config.ConstantConfig;
import cn.liuhp.core.service.EmailService;
import cn.liuhp.utils.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: demo类
 * @author: liuhp534
 * @create: 2019-08-17 17:44
 */
@Controller
@RequestMapping(path = "")
public class SpringBootDemoController {

    //两种写法
    //private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoController.class);
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmailService emailService;

    @Autowired
    private ConfigTest configTest;


    @RequestMapping(path = "springBootDemo")
    @ResponseBody
    public String springBootDemo(String param, HttpServletRequest request, HttpServletResponse response) {
        logger.info("session = {}", request.getSession().getId());//说明不会自己主动创建session
        request.getSession().setMaxInactiveInterval(5);//没有起作用
        /*String host=request.getHeader("host");
        if(host.indexOf(":")>-1){
            host=host.split(":")[0];
        }
        response.setHeader("host", host);*/
        //添加cookies
        Cookie ncookie = new Cookie("userName","我是大帅比");
        ncookie.setMaxAge(5);//5秒，这个起作用了
        response.addCookie(ncookie);
        return "hello springboot, " + param;
    }

    @RequestMapping(path = "out")
    public String out(HttpServletRequest request, HttpServletResponse response) {
        SessionUtils.removeSession(request, response);
        return "success";
    }


    @RequestMapping(path = "springConfig")
    @ResponseBody
    public String springConfig() {
        logger.info("springConfig调用。。。config.Max_Value={}", ConstantConfig.Max_Value);
        return configTest.toString();
    }

    @RequestMapping(path = "sendEmail")
    public String sendEmail(HttpServletRequest request, HttpServletResponse response) {
        logger.info("sendEmail");
        request.setAttribute("msg", "sendEmail success");
        emailService.sendEmail("sendEmail");
        return "success";
    }

    @RequestMapping(path = "publishEventBus")
    public String publishEventBus(HttpServletRequest request, HttpServletResponse response) {
        PersonEvent personEvent = new PersonEvent();
        DogEvent dogEvent = new DogEvent();
        EventBusCenter.post(personEvent);
        EventBusCenter.post(dogEvent);
        int i = 0;
        if (i==0) {
            throw new RuntimeException("人为抛出。，。");
        }
        return "success";
    }
}
