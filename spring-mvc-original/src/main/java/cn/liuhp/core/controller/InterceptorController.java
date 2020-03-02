package cn.liuhp.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-02 10:59
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {


    @RequestMapping("/method")
    public String interceptorMethod() {
        System.out.println("interceptorMethod");
        return "success";
    }

}
