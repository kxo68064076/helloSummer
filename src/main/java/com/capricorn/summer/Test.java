package com.capricorn.summer;

import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7");
        ThreadPoolExecutorConfig executorConfig = new ThreadPoolExecutorConfig();
        ThreadPoolExecutor executor = executorConfig.myThreadPoolExecutor();
        //顺序执行
//        long start = System.currentTimeMillis();
//        strings.forEach(s -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println(String.format("执行第%s条数据",s));
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        long end = System.currentTimeMillis();
//        System.out.println(String.format("执行一轮%s条数据耗时：%s ms",strings.size(),end-start));
        //多线程
        long start = System.currentTimeMillis();
        for(int i=0;i<strings.size();i++){
            String s = strings.get(i);
            executor.execute(()->{
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("线程%s执行数据%s",Thread.currentThread().getName(),s));
            });
        }

        executor.shutdown();

        while (true){
            if (executor.isTerminated()){
                System.out.println("线程任务执行完毕！");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("执行一轮%s条数据耗时：%s ms",strings.size(),end-start));
    }

    public static class ThreadPoolExecutorConfig {
        /**
         * 核心线程数
         */
        private static int corePoolSize;

        /**
         * 线程池中允许的最大线程数
         */
        private static int maximumPoolSize;

        /**
         * 线程空闲超时时间（秒）
         */
        private static final long keepAliveTime = 30;

        /**
         * 任务队列
         */
        private static final int capacity = 100;

        /**
         * 站内信、短信-线程池
         *
         * @return
         */
        public ThreadPoolExecutor myThreadPoolExecutor() {
            corePoolSize = Runtime.getRuntime().availableProcessors();
            maximumPoolSize = corePoolSize * 2;
            return new ThreadPoolExecutor(corePoolSize,
                    maximumPoolSize,
                    keepAliveTime,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(capacity));
        }
    }
}
