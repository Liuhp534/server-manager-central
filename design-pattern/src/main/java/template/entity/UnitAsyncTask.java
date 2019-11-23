package template.entity;

import java.util.List;
import java.util.concurrent.Callable;
/*
* 多线程任务处理单元
* */
public class UnitAsyncTask<T extends TaskDTO> implements Callable<Integer> {

    private Integer start;//任务的开始位置

    private Integer end;//任务的结束位置

    private List<T> taskList;//任务列表


    @Override
    public Integer call() throws Exception {
        int result = 0;
        if (null != this.taskList) {
            for (T t : taskList) {
                //TODO 执行具体任务
                System.out.println("执行任务" + t.toString());
                result ++;
            }
        }
        return result;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public List<T> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<T> taskList) {
        this.taskList = taskList;
    }
}
