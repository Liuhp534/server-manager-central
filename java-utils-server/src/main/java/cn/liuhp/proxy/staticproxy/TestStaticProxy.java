package cn.liuhp.proxy.staticproxy;

import cn.liuhp.proxy.UserService;
import cn.liuhp.proxy.UserServiceImpl;

/**
 * @author hz16092620
 * @date 2018年4月26日 上午10:50:05
 */
public class TestStaticProxy {


    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        UserService proxyService = new StaticHelloServiceProxy(service);
        System.out.println(proxyService.sayMorning("liuhp"));
    }

}
 