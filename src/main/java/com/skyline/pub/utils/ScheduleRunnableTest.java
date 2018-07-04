package com.skyline.pub.utils;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @create 2018/7/2
 */
@Component("scheduleRunnable")
public class ScheduleRunnableTest {
    private static ExecutorService service = Executors.newFixedThreadPool(8);
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.skyline");
        // 执行任务
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobId("123");
        scheduleJob.setMethodName("hello");
        scheduleJob.setBeanName("scheduleRunnable");
        scheduleJob.setParams("James");
        long startTime = System.currentTimeMillis();
        try {
            System.out.println("任务准备执行，任务ID：" + scheduleJob.getJobId());
            ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(), scheduleJob.getMethodName(),
                    scheduleJob.getParams());
            startTime = System.currentTimeMillis();
            Future<?> future = service.submit(task);
            future.get();
            long times = System.currentTimeMillis() - startTime;
            // 任务状态 0：成功 1：失败

            System.out.println("任务执行完毕，任务ID：" + scheduleJob.getJobId() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
            /**
             * Java Exception 捕获和展示 -- https://blog.csdn.net/hongweigg/article/details/18313461
             */
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            e.printStackTrace(new PrintStream(baos));
            String exception = baos.toString();
            System.out.println("任务执行失败，任务ID：" + scheduleJob.getJobId());
            System.out.println(exception.length() > 2000 ? exception.substring(0, 2000) :exception);
        }
    }
    private void hello(String name){
        System.out.println("hello " + name);
        if (1 < 2) {
            throw new RuntimeException("My Exception");
        }
    }
}
