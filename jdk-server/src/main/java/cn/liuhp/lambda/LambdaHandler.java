package cn.liuhp.lambda;

/**
 * @description: lambda处理工具
 * @author: liuhp534
 * @create: 2019-07-28 11:09
 */
@FunctionalInterface
public interface LambdaHandler<Integer, Double> {

    /*
    * 将计算结果按double返回
    * */
    Double operation(Integer x, Integer y);
}
