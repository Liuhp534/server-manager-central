package template.entity;

import template.AbstractTaskAllocationListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PlanTaskAllocationProcessor extends AbstractTaskAllocationListener {

    public ThreadPoolExecutor threadPoolExecutor;

    public int taskPageSize;
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

    }


    @Override
    public void init(ThreadPoolExecutor _threadPoolExecutor, int _taskPageSize) {
        super.init(_threadPoolExecutor, _taskPageSize);
    }

    @Override
    protected boolean isBlockedGetResult() {
        return Boolean.TRUE;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    public int getTaskPageSize() {
        return taskPageSize;
    }

    public void setTaskPageSize(int taskPageSize) {
        this.taskPageSize = taskPageSize;
    }
}
