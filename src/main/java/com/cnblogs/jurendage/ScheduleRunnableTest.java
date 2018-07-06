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
@Component("scheduleRunnableTest")
public class ScheduleRunnableTest {
    private static ExecutorService service = Executors.newFixedThreadPool(10);
    public static void main(String[] args) {
        System.out.println("tmpdir:"+System.getProperty("java.io.tmpdir"));
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
            future = service.submit(task);
            System.out.println("active count(after):"+((ThreadPoolExecutor)service).getActiveCount());
            future.get();
            long times = System.currentTimeMillis() - startTime;
            // 任务状态 0：成功 1：失败

            System.out.println("任务执行完毕，任务ID：" + scheduleJob.getJobId() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {
            /**
             * Java Exception 捕获和展示 -- https://blog.csdn.net/hongweigg/article/details/18313461
             */
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            e.printStackTrace(new PrintStream(baos));
            String exception = baos.toString();
            System.err.println("任务执行失败，任务ID：" + scheduleJob.getJobId());
            System.err.println(exception.length() > 2000 ? exception.substring(0, 2000) :exception);
        }
        System.out.println("active count(final):"+((ThreadPoolExecutor)service).getActiveCount());

    }

    private static ScheduleJob getScheduleJob() {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobId("123");
        scheduleJob.setMethodName("hello");
        scheduleJob.setBeanName("scheduleRunnableTest");
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
