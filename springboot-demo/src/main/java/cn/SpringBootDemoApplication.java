package cn;

import cn.liuhp.base.config.ConfigTest;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @description: 启动类
 * @author: liuhp534
 * @create: 2019-08-17 15:51
 */
@SpringBootApplication
public class SpringBootDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //System.setProperty("spring.config.location", "classpath:conf/env/application.properties");
        SpringApplication.run(SpringBootDemoApplication.class, args);
        logger.info("服务启动完成，用时={}", System.currentTimeMillis() - start);
    }
}
