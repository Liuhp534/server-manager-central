package cn.liuhp.base.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
/*
* 是作为一个组件，默认值，直接填写
* */
@Component
@ConfigurationProperties(prefix = "testConfig")
@PropertySource("classpath:configTest.properties")
@Data
public class ConfigTest {

    private String name = "john";

    private int age = 100;

    private List<String> likes;

}
