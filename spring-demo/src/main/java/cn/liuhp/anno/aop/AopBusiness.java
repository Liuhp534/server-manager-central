package cn.liuhp.anno.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;

/**
 * @description: aop业务
 * @author: liuhp534
 * @create: 2020-02-04 19:30
 */
public class AopBusiness {

    public AopBusiness () {
        System.out.println("AopBusiness 创建");
    }

    @Autowired
    private ApplicationContext applicationContext;

    public int calculate(int x, int y) {
        System.out.println("执行计算, 参数 x=" + x + " y=" + y);
        System.out.println("applicationContext=" + applicationContext);
        return x / y;
    }
}
