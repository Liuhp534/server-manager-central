package template.entity;

import template.AbstractTaskAllocationProcessor;
import template.entity.TaskDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PlanTaskAllocationProcessor extends AbstractTaskAllocationProcessor {

    public ThreadPoolExecutor threadPoolExecutor;

    /*
    * 特定类型的TaskDTO，扩展性好
    * */
    @Override
    protected List<? extends TaskDTO> searchList() {
        List<PlanTaskDTO> taskDTOList = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i ++) {
            taskDTOList.add(new PlanTaskDTO());
        }
        return taskDTOList;
    }
    @Override
    public void configHandlerThreadPool() {
        //子类定义线程池，属性是绑定类型的，而方法是绑定对象的，这里需要用到super
        super.threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    @Override
    protected boolean isBlockedGetResult() {
        return Boolean.TRUE;
    }
}
