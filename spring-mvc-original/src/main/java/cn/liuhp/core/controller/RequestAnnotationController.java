package cn.liuhp.core.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-01 14:14
 */
@RestController
@RequestMapping("/requestAnnotation")
public class RequestAnnotationController {


    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name") String name) {
        System.out.println(name);
        return "success";
    }


    @RequestMapping("/helloBody")
    public String helloBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /*** 接收请求 * @return */
    @RequestMapping(path = "/hello/{id}")
    public String sayHello(@PathVariable(value = "id") String id) {
        System.out.println(id);
        return "success";
    }

    @RequestMapping(path = "/header")
    public String helloHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println(header);
        return "success";
    }

    @RequestMapping(path = "/cookies")
    public String helloCookies(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println(cookieValue);
        return "success";
    }

}
