package cn.liuhp.anno.aop;

import org.aspectj.lang.annotation.Aspect;

/**
 * @description: aop业务
 * @author: liuhp534
 * @create: 2020-02-04 19:30
 */
public class AopBusiness {


    public int calculate(int x, int y) {
        System.out.println("执行计算, 参数 x=" + x + " y=" + y);
        return x / y;
    }
}
