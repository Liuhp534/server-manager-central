package cn.liuhp.aop.proxy;

/**
 * @description: 代理类实现类
 * @author: hz16092620
 * @create: 2019-06-14 17:21
 */
public class ISubjectImpl implements ISubject {

    @Override
    public String request() {
        return "请求响应 : " + System.currentTimeMillis();
    }
}
