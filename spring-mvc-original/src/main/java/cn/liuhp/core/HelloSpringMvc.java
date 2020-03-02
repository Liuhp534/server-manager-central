package cn.liuhp.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-02-29 21:22
 */
@Controller
@RequestMapping("/hello")
public class HelloSpringMvc {


    /*
     * http://localhost:8080/hello/sayHello?sayHello=jeff
     * */
    @RequestMapping(value = "/sayHello", method = {RequestMethod.GET}, params = {"sayHello=jeff"})
    @ResponseBody
    public String hello(String sayHello, Integer money) {
        return "hello original spring mvc to " + sayHello + " , money " + money;
    }


}
