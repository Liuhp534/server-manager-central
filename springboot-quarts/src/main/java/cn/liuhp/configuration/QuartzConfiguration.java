package cn.liuhp.configuration;

import cn.liuhp.CustomJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfiguration {


    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        //延长启动
        schedulerFactoryBean.setAutoStartup(Boolean.TRUE);
        schedulerFactoryBean.setStartupDelay(10);
        //设置加载的配置文件
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("/quartz.properties"));
        return schedulerFactoryBean;
    }


    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        //查询数据库或者配置文件
        JobDetailFactoryBean jobDetailFactoryBean=new JobDetailFactoryBean();
        jobDetailFactoryBean.setName("customJob");
        jobDetailFactoryBean.setBeanName(CustomJob.class.getName());
        jobDetailFactoryBean.setJobClass(CustomJob.class);
        jobDetailFactoryBean.setGroup("CustomJobGroup");
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
        triggerFactoryBean.setName("customTrigger");
        //jobDetails
        //triggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        triggerFactoryBean.setCronExpression("0/5 * * * * ?");
        //triggerFactoryBean.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY);
        triggerFactoryBean.setGroup("CustomJobGroup");
        return triggerFactoryBean;
    }

    @Bean
    public Scheduler scheduler() {
        Scheduler scheduler = schedulerFactoryBean().getScheduler();
        JobKey jobKey = new JobKey("customJob", "CustomJobGroup");
        JobDetail jobDetail = null;
        try {
            jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail != null) {
                scheduler.deleteJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        try {
            scheduler.scheduleJob(jobDetailFactoryBean().getObject(),cronTriggerFactoryBean().getObject());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return scheduler;
    }
}

