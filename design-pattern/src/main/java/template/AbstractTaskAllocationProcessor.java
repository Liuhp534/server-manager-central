package template;

import template.entity.TaskDTO;
import template.entity.UnitAsyncTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/*
多线程任务处理器
 */
public abstract class AbstractTaskAllocationProcessor {

    protected ThreadPoolExecutor threadPoolExecutor;

    protected int taskPageSize;

    public final void templateMethod() {//模板方法
        //步骤1，获取任务
        List<TaskDTO> taskDTOList = (List<TaskDTO>) this.searchList();
        if (null == taskDTOList || taskDTOList.size() <= 0 ) {
            System.out.println("无任务");
            return;
        }
        //步骤2，分配任务，处理成多个单元
        List<UnitAsyncTask> taskHandlerList = (List<UnitAsyncTask>) this.distributeList(taskDTOList);
        if (null == taskHandlerList || taskHandlerList.size() <= 0 ) {
            System.out.println("无处理任务");
            return;
        }
        //步骤3，提交任务到线程池执行
        List<Future<Integer>> dealResultList = this.submitHandlerList(taskHandlerList);
        //步骤4，阻塞获取执行结果，更具条件判断是否需要这样做
        if (this.isBlockedGetResult()) {
            if (null == dealResultList || dealResultList.size() <= 0 ) {
                System.out.println("无处理结果");
                return;
            }
            int result = this.blockedGetResult(dealResultList);
        }
    }


    //步骤1，获取任务
    protected abstract List<? extends TaskDTO> searchList();

    //步骤2，分配任务，处理成多个单元
    protected void configTaskPageSize() {
        this.taskPageSize = 100;
    }
    protected List<? extends UnitAsyncTask> distributeList(List<TaskDTO> taskDTOList) {
        List<UnitAsyncTask> taskHandlerList = null;
        UnitAsyncTask unitAsyncTask = null;
        try {
            int totalRecord = taskDTOList.size();
            taskHandlerList = new ArrayList<>(totalRecord);
            int pageCount = (totalRecord  +  taskPageSize  - 1) / taskPageSize;
            int start = 0;
            int end = 0;
            for (int i = 1; i <= pageCount; i++) {
                start = (i - 1) * taskPageSize;
                end = i * taskPageSize;
                if (end > totalRecord) {
                    end = totalRecord;
                }
                unitAsyncTask = new UnitAsyncTask();
                unitAsyncTask.setStart(start);
                unitAsyncTask.setEnd(end);
                unitAsyncTask.setTaskList(taskDTOList.subList(start, end));
                taskHandlerList.add(unitAsyncTask);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建任务异常");
            return null;
        }
        System.out.println("创建任务数量" + taskHandlerList.size());
        return taskHandlerList;
    }

    //步骤3，提交任务到线程池执行
    protected void configHandlerThreadPool() {//钩子方法
        //核心线程数2，最大线程数4，线程多久空闲销毁，工作队列
        this.threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1));
    }

    protected List<Future<Integer>> submitHandlerList(List<? extends UnitAsyncTask> handlerList) {
        List<Future<Integer>> dealResultList = new ArrayList<>();
        try {
            for (Callable<Integer> handler : handlerList) {
                dealResultList.add(this.threadPoolExecutor.submit(handler));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("提交任务异常，提交数量=" + dealResultList.size());
        }
        System.out.println("提交任务数量" + dealResultList.size());
        return dealResultList;
    }

    //步骤4，获取执行结果
    protected boolean isBlockedGetResult() {//钩子方法
        return Boolean.FALSE;
    }

    protected int blockedGetResult(List<Future<Integer>> dealResult) {
        int result = 0;
        for (Future<Integer> integerFuture : dealResult) {
            try {
                result += integerFuture.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("完成任务量=" + result);
        return result;
    }














}
