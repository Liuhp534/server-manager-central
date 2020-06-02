package cn.liuhp.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author hz16092620
 * @date 2018年4月26日 上午11:48:02
 */
public class TestCglibProxy {

    public static void main(String[] args) {
		fun1();
    }


    private static void fun1() {
    	Requestable requestable = (Requestable) new CustomProxy().getInstance(Requestable.class);

		requestable.request();
		System.out.println(requestable instanceof Requestable);
		System.out.println(requestable.getClass());
	}

}
 