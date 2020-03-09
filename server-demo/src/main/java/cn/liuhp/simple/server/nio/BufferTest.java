package cn.liuhp.simple.server.nio;

import java.nio.ByteBuffer;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-08 19:37
 */
public class BufferTest {


    public static void main(String[] args) {
        //fun1();
        fun2();
    }

    /*
    * 直接缓冲区
    * */
    private static void fun2() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        System.out.println(byteBuffer.isDirect());
    }

    /*
    * 常用方法
    * */
    private static void fun1() {
        //1 分配空间
        ByteBuffer buffer = ByteBuffer.allocate(100);
        printBufferDetail(buffer, "1 分配空间");
        //2 输入数据
        buffer.put("12345".getBytes());
        printBufferDetail(buffer, "2 输入数据");
        //3 转换为读模式
        buffer.flip();
        printBufferDetail(buffer, "3 转换为读模式");
        //4 读取数据
        byte[] str = new byte[2];
        buffer.get(str, 0, 2);
        printBufferDetail(buffer, "4 读取数据");
        System.out.println("获取数据=" + new String(str));
        //5 标记位置
        buffer.mark();
        printBufferDetail(buffer, "5 标记位置");
        //6 重置mark位置
        buffer.reset();
        printBufferDetail(buffer, "6 重置mark位置");
    }

    private static void printBufferDetail(ByteBuffer buffer, String detail) {
        System.out.println("=====" + detail);
        System.out.println("capacity=" + buffer.capacity());
        System.out.println("limit=" + buffer.limit());
        System.out.println("position=" + buffer.position());
        System.out.println("mark=" + buffer.mark());
    }
}
