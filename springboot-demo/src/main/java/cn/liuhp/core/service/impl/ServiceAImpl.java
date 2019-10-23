package cn.liuhp.core.service.impl;

import cn.liuhp.core.service.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceAImpl implements ServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(ServiceAImpl.class);

    public ServiceAImpl() {
        System.out.println("ServiceAImpl.....create");
    }


    @Override
    public void service() {
        logger.info("ServiceAImpl provider service...");
    }
}
