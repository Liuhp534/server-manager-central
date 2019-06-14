package cn.liuhp.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @description: 播放器切面
 * @author: hz16092620
 * @create: 2019-06-13 16:35
 */
@Aspect
public class BlackDiscAspect {


    private int playCount = 0;

    @Pointcut("execution(* cn.liuhp.aop.aspect.BlackDisc.playSong(int)) && args(number)")
    public void trackPlayed(int number) {

    }

    @Before("trackPlayed(number)")
    public void count(int number) {
        System.out.println("正在准备播放 " + number);
        playCount ++;
    }

    public int getPlayCount() {
        return this.playCount;
    }

}
