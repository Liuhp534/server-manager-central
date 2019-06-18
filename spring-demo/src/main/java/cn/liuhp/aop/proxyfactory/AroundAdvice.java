package cn.liuhp.aop.proxyfactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/**
 * @description: 前后advice
 * @author: hz16092620
 * @create: 2019-06-18 09:31
 */
public class AroundAdvice implements MethodInterceptor {

    private final Log logger = LogFactory.getLog(this.getClass());


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch watch = new StopWatch("advice任务");
        try {
            System.out.println("advice before....");
            Thread.sleep(1000);
            watch.start("任务一");
            return invocation.proceed();
        } finally {
            watch.stop();
            System.out.println("advice after...." + System.lineSeparator());
            System.out.println(watch.prettyPrint());
            //logger.debug("I'm logger....");
        }
    }
}
