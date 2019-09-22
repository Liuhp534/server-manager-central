package cn.liuhp.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @description: around类型的切面
 * @author: liuhp534
 * @create: 2019-06-19 10:35
 */
@Aspect
public class BlackDiscAroundAspect {

    @Pointcut("execution(* cn.liuhp.aop.aspect.BlackDisc.playSong(int)) && args(number)")
    public void trackPlayed(int number) {

    }


    @Around("trackPlayed(int)")
    public Object aroundExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(pjp.getSignature().getName());
        System.out.println(pjp.getSignature().getClass());
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        System.out.println("classname:" + targetMethod.getDeclaringClass().getName());
        System.out.println("superclass:" + targetMethod.getDeclaringClass().getSuperclass().getName());
        System.out.println("simpleName:" + targetMethod.getDeclaringClass().getSimpleName());
        System.out.println("isinterface:" + targetMethod.getDeclaringClass().isInterface());
        System.out.println("target:" + pjp.getTarget().getClass().getName());
        System.out.println("proxy:" + pjp.getThis().getClass().getName());
        System.out.println("method:" + targetMethod.getName());
        System.out.println(getLoggerMethodName(targetMethod.getDeclaringClass().getName(), targetMethod.getName()));
        StopWatch watch = new StopWatch("around");
        try {
            watch.start("任务一");
            Object[] args = pjp.getArgs();
            for (Object obj : args) {
                System.out.println("参数：" + obj);
            }
            return pjp.proceed();
        } finally {
            watch.stop();
            //System.out.println(watch.prettyPrint());
        }

    }


    private String getLoggerMethodName(String className, String methodName) {
        if (!StringUtils.isEmpty(className)) {
            String[] names = className.split("\\.");
            return names[names.length - 1] + "." + methodName;
        }
        return methodName;
    }
}
