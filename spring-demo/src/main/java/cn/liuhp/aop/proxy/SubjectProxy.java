package cn.liuhp.aop.proxy;

/**
 * @description: 代理类
 * @author: hz16092620
 * @create: 2019-06-14 17:22
 */
public class SubjectProxy implements  ISubject {

    private ISubject subject;

    public SubjectProxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public String request() {
        String result = this.subject.request();
        return "proxy ->" + result;
    }
}
