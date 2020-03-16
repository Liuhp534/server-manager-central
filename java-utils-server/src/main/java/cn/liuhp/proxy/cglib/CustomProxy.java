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
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        System.out.println("before");
        Object result = arg3.invokeSuper(arg0, arg2);
        System.out.println("after");
        return result;
    }


}
 