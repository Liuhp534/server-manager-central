package cn.liuhp.core.service.impl;

import cn.liuhp.core.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
* 这里不能写注解
* */
public class DefaultEmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultEmailServiceImpl.class);

    @Override
    public void sendEmail() {
        logger.info("default send email。。。");
    }
}
