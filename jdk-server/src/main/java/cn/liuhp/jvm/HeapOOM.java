package cn.liuhp.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 堆溢出test
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError 可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后进行分析
 * @author: hz16092620
 * @create: 2019-04-24 14:35
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
