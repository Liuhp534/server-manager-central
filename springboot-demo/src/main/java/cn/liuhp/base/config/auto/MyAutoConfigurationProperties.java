package cn.liuhp.base.config.auto;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-02-23 10:40
 */
@ConfigurationProperties("myAutoConfig")
public class MyAutoConfigurationProperties {

    private String myAutoConfigName = "liu";

    public String getMyAutoConfigName() {
        return myAutoConfigName;
    }

    public void setMyAutoConfigName(String myAutoConfigName) {
        this.myAutoConfigName = myAutoConfigName;
    }
}
