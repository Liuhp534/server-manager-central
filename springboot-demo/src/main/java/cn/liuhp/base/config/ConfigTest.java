package cn.liuhp.base.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

@ConfigurationProperties(prefix = "testConfig")
@PropertySource("classpath:configTest.properties")
@Data
public class ConfigTest {

    private String name;

    private int age;

    private List<String> likes;

}
