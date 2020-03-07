package cn.liuhp.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-07 19:11
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    @ResponseBody
    public String index() {
        return "index";
    }

}
