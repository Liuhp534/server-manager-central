package cn.liuhp.base.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

public class CustomApplicationStartListener implements SpringApplicationRunListener {

    private final SpringApplication application;

    private final String[] args;

    private static final Logger logger = LoggerFactory.getLogger(CustomApplicationStartListener.class);

    public CustomApplicationStartListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        logger.info("application start listener...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        logger.info("application environmentPrepared listener...");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        logger.info("application contextPrepared listener...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        logger.info("application contextLoaded listener...");
    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        logger.info("application finished listener...");
    }


}
