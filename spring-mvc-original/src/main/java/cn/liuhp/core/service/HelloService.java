package cn.liuhp.core.service;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-02 17:51
 */
@Service
public class HelloService {


    public String sayHello() {
        System.out.println("hello service");
        return "hello service";
    }

}
