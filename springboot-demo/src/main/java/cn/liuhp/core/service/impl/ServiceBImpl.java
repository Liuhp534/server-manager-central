package cn.liuhp.core.service.impl;

import cn.liuhp.core.service.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceBImpl implements ServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(ServiceBImpl.class);

    public ServiceBImpl() {
        System.out.println("ServiceBImpl.....create");
    }

    @Override
    public void service() {
        logger.info("ServiceBImpl provider service...");
    }
}
