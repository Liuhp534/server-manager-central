package cn.liuhp.anno.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @description: aop的切面逻辑
 * @author: liuhp534
 * @create: 2020-02-04 19:34
 */
@Aspect
public class AopAspect {

    @Pointcut("execution(public Integer cn.liuhp.anno.aop.AopBusiness.calculate(..))")
    public void pointCut() {

    }


    @Before("pointCut()")
    public void businessBefore() {
        System.out.println("[AopAspect]方法执行之前");
    }

    @After("pointCut()")
    public void businessEnd() {
        System.out.println("[AopAspect]方法执行之后");
    }

    @AfterReturning(value="pointCut()", returning = "result")
    public void businessReturn(Object result) {
        System.out.println("[AopAspect]方法返回值" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void businessException(Exception exception) {
        System.out.println("[AopAspect]方法异常");
    }

    @Around("pointCut()")
    public Object businessAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        try {
            System.out.println("[AopAspect]方法环绕之前");
            result = pjp.proceed();
            System.out.println("[AopAspect]方法环绕之后");
        } catch (Throwable throwable) {
            //throwable.printStackTrace();
           // throw throwable;
        }
        return result;
    }


}
