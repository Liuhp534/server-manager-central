package cn.liuhp.anno.config.ext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @description: BeanFactory后置处理配置
 * @author: liuhp534
 * @create: 2020-02-07 14:18
 */
@Configuration
@ComponentScans({@ComponentScan("cn.liuhp.anno.listener"),@ComponentScan("cn.liuhp.anno.post")})
public class BeanFactoryPostConfig {
}
