package cn.liuhp.core.service.impl;

import cn.liuhp.core.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

@Service
public class GoogleEmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(GoogleEmailServiceImpl.class);

    @Override
    public void sendEmail(String content) {
        logger.info(content + ", Google send email。。。");
    }
}
