package cn.liuhp.base.config;

import cn.liuhp.base.listener.MyListener;
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
}
