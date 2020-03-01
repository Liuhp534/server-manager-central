package cn.liuhp.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-02-29 21:22
 */
@Controller
@RequestMapping("/hello")
public class HelloSpringMvc {

    @RequestMapping("/sayHello")
    @ResponseBody
    public String hello() {
        return "hello original spring mvc";
    }

}
