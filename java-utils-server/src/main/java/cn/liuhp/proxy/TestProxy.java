package cn.liuhp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author hz16092620
 * @date 2018年4月23日 下午7:54:31
 */
public class TestProxy {

    public static void main(String[] args) {
        fun1();
    }



    private static void fun1() {
        UserService service = new UserServiceImpl();
        System.out.println(service instanceof UserService);
        //实现特定业务的代理类
        CustomJdkProxy proxy = new CustomJdkProxy(service);
        //参数和具体的实现类对象没有关系，第二个参数UserService.class.getInterfaces()获取的是接口的接口，不要理错了。
        service = (UserService) proxy.getInstance(UserServiceImpl.class);
        service.sayMorning("aaa");
        System.out.println(service instanceof UserService);
        System.out.println(service.toString());
        System.out.println(service.getClass());
    }


}
 