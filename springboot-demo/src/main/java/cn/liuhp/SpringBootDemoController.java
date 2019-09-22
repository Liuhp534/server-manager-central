package cn.liuhp;

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



    @RequestMapping(path = "springBootDemo")
    @ResponseBody
    public String springBootDemo(String param) {
        return "hello springboot, " + param;
    }



}
