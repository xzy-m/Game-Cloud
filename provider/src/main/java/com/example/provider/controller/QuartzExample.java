package com.example.provider.controller;

import com.example.provider.tool.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author XRS
 * @date 2025-06-21 下午 11:00
 */
public class QuartzExample {
    public static void main(String[] args) {
        try {
            //创建scheduler实例
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            //定义Job实例
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("hello", "group")
                    .build();

            //创建Trigger实例，定义执行规则，这里就每五秒来句hello
            SimpleTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger", "group")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                    .build();

            //再把job,trigger注册到scheduler
            scheduler.scheduleJob(job, trigger);

            //运行一会后关闭
            Thread.sleep(30000);
            scheduler.shutdown();

        } catch (SchedulerException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
