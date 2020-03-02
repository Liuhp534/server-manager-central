package cn.liuhp.core;

import cn.liuhp.base.exception.CustomBusinessException;
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
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping(value = "/math")
    @ResponseBody
    public String math() {
        int i = 1 / 0;
        return "math";
    }

    @RequestMapping(value = "/customMath")
    @ResponseBody
    public String customMath() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new CustomBusinessException("计算错误");
        }
        return "math";
    }

}
