package cn.liuhp.base.listener;

import cn.liuhp.base.config.ConstantConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

@Component
public class MyListener extends ContextLoaderListener {


    private static final Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.info("容器初始化。。。");
        ConstantConfig.Max_Value = 100000;//这个可以起作用，说明了实例化完之后进行操作的
        //super.contextInitialized(event);

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger.info("容器销毁。。。");
        //super.contextDestroyed(event);
    }
}
