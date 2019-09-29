package cn.liuhp.base.config;

import cn.liuhp.base.listener.CustomEventListener;
import cn.liuhp.base.listener.CustomHttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*
* web mvc相关的配置
* */
@Configuration
public class WebServerConfig extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(CustomEventListener.class);

    /*
    * 配置httpsession监听器
    * */
    @Bean
    public ServletListenerRegistrationBean httpSessionListener() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new CustomHttpSessionListener());
        return srb;
    }

}
