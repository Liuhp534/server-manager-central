package cn.liuhp.aop.aspect;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @description: 切面的测试
 * @author: liuhp534
 * @create: 2019-06-19 10:31
 */
public class AspectTest {


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setProxyTargetClass(Boolean.TRUE);
        proxyFactory.setTarget(new BlackDisc());
        proxyFactory.addAspect(BlackDiscAroundAspect.class);
        BlackDisc proxy = proxyFactory.getProxy();
        proxy.playSong(2);
    }
}
