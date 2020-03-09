package cn.liuhp.simple.server.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-09 11:13
 */
public class ChannelTest {


    public static void main(String[] args) throws Exception {
        //fun1();
        //fun2();
        fun3();
    }

    /*
    * 编码解码工具
    * */
    private static void fun3() throws Exception {
        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();

        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("刘大帅哥！");
        cBuf.flip();

        //编码
        ByteBuffer bBuf = ce.encode(cBuf);

        for (int i = 0; i < bBuf.limit(); i++) {
            System.out.println(bBuf.get());
        }

        //解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());

        System.out.println("------------------------------------------------------");

        Charset cs2 = Charset.forName("GBK");
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3.toString());
    }

    /*
    * 分散和聚集
    * */
    private static void fun2() throws Exception {
        RandomAccessFile raf1 = new RandomAccessFile("C:\\Users\\liuhp\\Desktop\\20190422012393投保单信息.txt", "rw");

        //1. 获取通道
        FileChannel channel1 = raf1.getChannel();

        //2. 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(500);

        //3. 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);

        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();
            System.out.println("-----------------");
            System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));
        }

        //4. 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("H:\\202003_home\\copy_two_20190422012393.txt", "rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }

    /*
    * 读取文件
    * */
    private static void fun1() throws Exception {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\liuhp\\Desktop\\20190422012393投保单信息.txt");
        FileOutputStream outputStream = new FileOutputStream("H:\\202003_home\\copy_20190422012393.txt");

        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(256);

        while (inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }


    }
}
