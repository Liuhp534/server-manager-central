package cn.liuhp.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @description: cglib代理测试
 * @author: hz16092620
 * @create: 2019-06-14 17:57
 */
public class CglibProxy {


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(new RequestCallback());

        Requestable requestable = (Requestable) enhancer.create();
        System.out.println(new Requestable().getClass().toString());
        System.out.println(requestable.getClass());
        requestable.request();
    }
}
