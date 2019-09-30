package cn.liuhp.base.config;

import cn.liuhp.base.listener.MyListener;
import cn.liuhp.core.service.EmailService;
import cn.liuhp.core.service.impl.DefaultEmailServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {


    /*
    * 将监听器作为组件添加到容器中
    * */
    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }



    /*
    * 当没有emailService实现的时候，使用默认的实现
    * */
    @Bean
    @ConditionalOnMissingBean(EmailService.class)
    public EmailService createEmailService() {
        return new DefaultEmailServiceImpl();
    }

}
