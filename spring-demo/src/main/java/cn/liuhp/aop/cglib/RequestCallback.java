package cn.liuhp.aop.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: 代理类
 * @author: hz16092620
 * @create: 2019-06-14 17:55
 */
public class RequestCallback implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("请求之前");
        return methodProxy.invokeSuper(o, objects);
    }
}
