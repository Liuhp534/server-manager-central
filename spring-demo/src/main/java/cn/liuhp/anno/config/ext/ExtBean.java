package cn.liuhp.anno.config.ext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: 自定义组件，用于查看创建流程
 * @author: liuhp534
 * @create: 2020-02-08 20:09
 */
@Component
public class ExtBean {

    @Value("${extBeanName}")
    private String extBeanName;

    private String city;

    @Autowired
    private BeanFactory beanFactory;

    public ExtBean () {
        System.out.println("创建extBean");
    }


}
