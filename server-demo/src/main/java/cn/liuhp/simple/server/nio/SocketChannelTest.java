package cn.liuhp.simple.server.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-09 13:01
 */
public class SocketChannelTest {

    public static void main(String[] args) {
        fun2();
    }

    /*
    * 服务端接收信息
    * */
    static void fun2() {
        try {
            //1 获取服务端套接字通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //2 通道绑定端口
            serverSocketChannel.bind(new InetSocketAddress(8888));
            //3 获取客户端的通道
            SocketChannel clientSocket = serverSocketChannel.accept();
            System.out.println("获取套接字" + clientSocket);
            //4 定义buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            //5 服务端接收数据通道
            FileChannel outChannel = FileChannel.open(Paths.get("H:\\202003_home\\serverSocket.txt"),
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            //6 接收数据
            while (clientSocket.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            //7 响应消息
            byteBuffer.put("收到数据".getBytes());
            byteBuffer.flip();
            clientSocket.write(byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 客户端传输文件到服务器
    * */
    static void fun1() {
        try {
            //1 获取套接字通道
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
            //2 获取需要传输的文件的通道
            FileChannel fileChannel = FileChannel.open(Paths.get("C:\\Users\\liuhp\\Desktop\\20190422012393投保单信息.txt"),
                    StandardOpenOption.READ);
            //3 定义buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            //4 通过之间传输
            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            //5 获取反馈信息
            socketChannel.shutdownOutput();//关闭输出连接
            int length = 0;
            while ((length = socketChannel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array(), 0, length));
                byteBuffer.clear();
            }
            fileChannel.close();
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
