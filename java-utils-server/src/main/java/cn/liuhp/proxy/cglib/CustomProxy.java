package cn.liuhp.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hz16092620
 * @date 2018年4月26日 上午11:42:34
 */
public class CustomProxy implements MethodInterceptor {


    public Object getInstance(Class clazz) {
        Enhancer en = new Enhancer();
        en.setSuperclass(clazz);
        en.setCallback(this);

		/*//可以通过类型
		en.setCallbackType(RequestCallback.class);
		Class class1 = en.createClass();
		try {
			Requestable re1 = (Requestable) class1.newInstance();
			Requestable result = (Requestable) class1.getConstructor().newInstance(new Object[0]);
			re1.request();
			result.request();
			System.out.println(class1);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

        Object object = en.create();
        return object;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //object是代理后的子类  ，method是调用方法 ，args是方法入参 ， proxy是MethodProxy代理对象
        /*System.out.println(object.getClass());
        System.out.println(object.toString());*/
        System.out.println("before");
        Object result = methodProxy.invokeSuper(object, args);
        //Object result = method.invoke(object, args);
        System.out.println("after");
        return result;
    }


}
 