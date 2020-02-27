package cn.liuhp.bean;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-02-24 20:17
 */
@Configuration
public class MvcConfiguration {


    //通过配置一个嵌入式的Servlet容器的定制器，来配置容器
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8888);
            }
        };
    }


}
