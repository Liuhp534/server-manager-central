package cn.liuhp.aop.proxyfactory;

/**
 * @description: 被代理对象
 * @author: hz16092620
 * @create: 2019-06-18 09:28
 */
public class ITaskImpl implements ITask {



    @Override
    public void execute() {
        System.out.println("execute....");
    }
}
