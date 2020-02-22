package cn.liuhp.base.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
/*
* 是作为一个组件，默认值，直接填写
* */
@Component
@ConfigurationProperties(prefix = "testConfig")
@PropertySource("classpath:configurationProperties.properties")//指定配置文件的位置
@Data
public class ConfigurationPropertiesTest {

    private String name = "john";

    private int age = 100;

    private List<String> likes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }
}
