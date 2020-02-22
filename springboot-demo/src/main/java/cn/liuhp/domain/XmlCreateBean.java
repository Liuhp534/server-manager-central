package cn.liuhp.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * @description: xml创建的bean
 * @author: liuhp534
 * @create: 2020-02-22 19:48
 */
public class XmlCreateBean {

    @Value("${xmlCreateBeanName}")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
