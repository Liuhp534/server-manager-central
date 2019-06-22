package cn.liuhp.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

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
    public Object aroundExecute(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch("around");
        try {
            watch.start("任务一");
            System.out.println("准备执行。。。。" + joinPoint.getArgs()[0]);
            return joinPoint.proceed();
        } finally {
            watch.stop();
            System.out.println(watch.prettyPrint());
        }

    }
}
