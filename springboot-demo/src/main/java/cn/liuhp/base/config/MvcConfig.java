package cn.liuhp.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @description: mvc配置
 * @author: liuhp534
 * @create: 2019-09-28 11:03
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置一个controller，跳转success
        registry.addViewController("/mvcConfig").setViewName("success");
        super.addViewControllers(registry);
    }
}
