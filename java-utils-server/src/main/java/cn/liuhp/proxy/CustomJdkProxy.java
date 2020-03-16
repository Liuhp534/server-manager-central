package cn.liuhp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hz16092620
 * @date 2018年4月3日 下午5:50:14
 */
public class CustomJdkProxy implements InvocationHandler {

    private Object proxy;

    CustomJdkProxy(Object proxy) {
        this.proxy = proxy;
    }

    public Object getInstance(Class clazz) {
        Object object = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return object;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("执行之前。。。。");
        Object result = method.invoke(proxy, args);
        System.out.println("执行之后。。。。");
        return result;
    }

}
 