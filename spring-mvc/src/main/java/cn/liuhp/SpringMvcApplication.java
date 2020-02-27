package cn.liuhp;

import com.liuhp.annotation.EnableLiuhp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 程序入口
 * @author: liuhp534
 * @create: 2020-02-24 11:19
 */
@SpringBootApplication
//@EnableLiuhp
public class SpringMvcApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringMvcApplication.class);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            SpringApplication application = new SpringApplication(SpringMvcApplication.class);
            Map<String, Object> defaultMap = new HashMap<String, Object>();
            defaultMap.put("server.port", 9093);//有效
            //还可以是Properties对象
            application.setDefaultProperties(defaultMap);
            application.run(args);
        } catch (Exception e) {
            logger.error("springMvc程序启动失败");
            e.printStackTrace();
        }
        logger.info("springMvc程序启动完成，耗时 {} 毫秒", System.currentTimeMillis() - start);
    }

}
