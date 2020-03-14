package cn.liuhp.reflect.impl;

import cn.liuhp.reflect.ActionHandler;

/**
 * @author hz16092620
 * @date 2018年4月3日 下午4:03:05
 */
public class TestReflect {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        try {
            ActionHandler ah = (ActionHandler) Class.forName("cn.liuhp.reflect.impl.ChinaActionHandler").newInstance();
            ah.handler();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
 