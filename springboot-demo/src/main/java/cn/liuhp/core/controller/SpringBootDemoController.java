package cn.liuhp.core.controller;

import cn.SpringBootDemoApplication;
import cn.liuhp.base.config.ConfigTest;
import cn.liuhp.base.config.ConstantConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @description: demo类
 * @author: liuhp534
 * @create: 2019-08-17 17:44
 */
@Controller
@RequestMapping(path = "springBoot")
public class SpringBootDemoController {

    //两种写法
    //private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoController.class);
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ConfigTest configTest;


    @RequestMapping(path = "springBootDemo")
    @ResponseBody
    public String springBootDemo(String param) {
        return "hello springboot, " + param;
    }


    @RequestMapping(path = "springConfig")
    @ResponseBody
    public String springConfig() {
        logger.info("springConfig调用。。。config.Max_Value={}", ConstantConfig.Max_Value);
        return configTest.toString();
    }
}
