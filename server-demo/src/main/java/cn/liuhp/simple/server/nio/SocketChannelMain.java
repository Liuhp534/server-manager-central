package cn.liuhp.simple.server.nio;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-09 13:15
 */
public class SocketChannelMain {


    public static void main(String[] args) {
        SocketChannelTest.fun1();//客户端传输文件
    }

    private static void fun1() {
        SocketChannelTest.fun2();//开启服务端

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SocketChannelTest.fun1();//客户端传输文件
    }
}
