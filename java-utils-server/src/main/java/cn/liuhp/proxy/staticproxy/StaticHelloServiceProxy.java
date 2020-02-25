package cn.liuhp.proxy.staticproxy;

import cn.liuhp.proxy.UserService;


/**
 * @author hz16092620
 * @date 2018年4月26日 上午10:48:26
 */
public class StaticHelloServiceProxy implements UserService {

    private UserService userService;

    StaticHelloServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String sayMorning(String name) {
        System.out.println("before do someting....");
        String result = userService.sayMorning(name);
        System.out.println("after do something...");
        return "proxy result : " + result;
    }

}
 