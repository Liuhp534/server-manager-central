package template;

import template.entity.PlanTaskAllocationProcessor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TemplateMain {


    public static void main(String[] args) {
        fun1();
    }


    private static void fun1() {
        PlanTaskAllocationProcessor processor = new PlanTaskAllocationProcessor();
        //子类定义线程池，属性是绑定类型的，而方法是绑定对象的，这里需要用到super
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        processor.init(threadPoolExecutor, 1000);
        System.out.println(processor.taskPageSize);
        System.out.println(processor.threadPoolExecutor);
        AbstractTaskAllocationListener father = processor;
        System.out.println(father.taskPageSize);
        System.out.println(father.threadPoolExecutor);
        processor.templateMethod();
    }
}
