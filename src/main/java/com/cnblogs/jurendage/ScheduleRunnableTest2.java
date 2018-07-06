package com.cnblogs.jurendage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @create 2018/7/2
 */
@Component("scheduleRunnableTest2")
public class ScheduleRunnableTest2 {
    public static void main(String[] args) {
        System.out.println("tmpdir:"+System.getProperty("java.io.tmpdir"));
         ExecutorService service = Executors.newCachedThreadPool();
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.skyline","com.cnblogs");
        // 执行任务
        ScheduleJob scheduleJob = getScheduleJob();
        long startTime = System.currentTimeMillis();
        Future<?> future = null;
        try {
            System.out.println("任务准备执行，任务ID：" + scheduleJob.getJobId());
            ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(), scheduleJob.getMethodName(),
                    scheduleJob.getParams());
            startTime = System.currentTimeMillis();

            System.out.println("active count(before):"+((ThreadPoolExecutor)service).getActiveCount());
            future = doTest(service, future, task);
            future.get();
            long times = System.currentTimeMillis() - startTime;
            System.out.println("任务执行完毕，任务ID：" + scheduleJob.getJobId() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {

        }

    }

    private static Future<?> doTest(ExecutorService service, Future<?> future, ScheduleRunnable task) {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future = service.submit(task);
            System.out.println("active count:"+((ThreadPoolExecutor)service).getActiveCount());
        }
        return future;
    }

    private static ScheduleJob getScheduleJob() {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobId("123");
        scheduleJob.setMethodName("hello");
        scheduleJob.setBeanName("scheduleRunnableTest2");
        scheduleJob.setParams("James");
        return scheduleJob;
    }

    private void hello(String name) throws Exception {
        System.out.println("hello " + name);
        if (1 < 2) {
//            throw new Exception("My Exception");
        }
    }
}
