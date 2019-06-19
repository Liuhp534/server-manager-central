package cn.liuhp.aop.proxyfactory;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @description: 织入测试
 * @author: hz16092620
 * @create: 2019-06-18 09:30
 */
public class WeaveTest {


    public static void main(String[] args) {
        test();
        //testCglib();
    }


    /*通过接口的方式*/
    private static void test() {
        ITaskImpl task = new ITaskImpl();//这里为什么不用接口定义呢？
        ProxyFactory weaver = new ProxyFactory(task);
        //weaver.setProxyTargetClass(Boolean.TRUE);//这个可以配置为cglib的方式代理
        //加入代理的接口，表示通过动态代理的方式
        //weaver.setInterfaces(new Class[] {ITask.class});//不set也可以智能的加载
        //定义advisor
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.addMethodName("execute");
        advisor.setAdvice(new AroundAdvice());
        weaver.addAdvisor(advisor);
        //获取代理对象，如果不加卢advisor，相当于什么都不做。
        ITask iTask = (ITask) weaver.getProxy();
        iTask.execute();
        System.out.println(iTask.getClass());
    }

    /*生成代理类，通过cglib*/
    private static void testCglib() {
        Executable targetObject = new Executable();
        ProxyFactory weaver = new ProxyFactory(targetObject);
        //定义advisor
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.addMethodName("execute");
        advisor.setAdvice(new AroundAdvice());
        weaver.addAdvisor(advisor);
        //获取代理对象，如果不加卢advisor，相当于什么都不做。
        Executable proxyObject = (Executable) weaver.getProxy();
        proxyObject.execute();//如果是final方法，那么就只会执行这个方法，不会有代理的功能
        System.out.println(proxyObject.getClass());
    }
}
