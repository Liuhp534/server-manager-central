package cn.liuhp.utils;

import cn.liuhp.core.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
* CommandLineRunner实现在应用启动后，去执行相关代码逻辑，且只会执行一次; 多个可以定义order
* */
@Order(value=1)
@Component
public class TestTwoUtils implements CommandLineRunner {

    @Autowired
    private EmailService emailService;

    @Override
    public void run(String... strings) throws Exception {
        emailService.sendEmail("TestTwoUtils");
    }
}
