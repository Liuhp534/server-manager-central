package cn.liuhp;

import cn.liuhp.utils.JackJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
//只需要在Job类上加上这个注解即可，串行 QRTZ_JOB_DETAILS.IS_NONCONCURRENT=1
@DisallowConcurrentExecution
@Slf4j
public class CustomJob extends QuartzJobBean {



    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("执行开始");
        log.info(jobExecutionContext.toString());
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("执行结束");
    }
}
