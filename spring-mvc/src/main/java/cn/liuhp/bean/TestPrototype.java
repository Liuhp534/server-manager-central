package cn.liuhp.bean;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/*
* 原型模式，可以创建多个
* */
public class TestPrototype {

    private static final AtomicInteger ato = new AtomicInteger(0);


    public TestPrototype() {
        System.out.println("TestPrototype=========" + ato.addAndGet(1));
    }

}
