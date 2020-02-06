package cn.liuhp.jvm;

import sun.misc.VM;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 直接内存溢出
 * @author: hz16092620
 * @create: 2019-04-24 17:09
 */
public class DirectBufferOom {

    public static void main(String[] args) {
        System.out.println(VM.maxDirectMemory() / 1024/1024 + "MB");
        final int _1M = 1024 * 1024;
        List<ByteBuffer> buffers = new ArrayList<>();
        int count = 1;
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1M);
            buffers.add(byteBuffer);
            System.out.println(count++);
        }
    }
}
