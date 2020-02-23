package cn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @description: 启动类
 * @author: liuhp534
 * @create: 2019-08-17 15:51
 */
@PropertySource("classpath:logback.properties")//想引入logback的配置发现无效，只能放到application.properties
@ImportResource({"classpath:beans.xml"})//导入Spring的配置文件，让配置文件里面的内容生效，需标注在一个配置类上
@SpringBootApplication
public class SpringBootDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.setProperty("spring.config.location", "classpath:springConfigLocation.properties");//改变默认配置文件位置，有效
        SpringApplication.run(SpringBootDemoApplication.class, args);
        logger.info("服务启动完成，用时={}", System.currentTimeMillis() - start);
    }
}
