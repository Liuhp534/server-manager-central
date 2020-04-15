package cn.liuhp.core.controller;

//import com.liuhp.core.LiuhpSpeaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-02-24 11:28
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

   /* @Autowired
    private LiuhpSpeaker liuhpSpeaker;
*/
    @RequestMapping("sayHello")
    @ResponseBody
    public String hello() {
        logger.trace("我是trace");
        logger.debug("我是debug");
        logger.info("我是info");
        logger.error("我是error");
        return "sayHello";
    }

}
