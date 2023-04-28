package com.capricorn.summer;

import java.util.concurrent.*;

public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("开始任务");
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> future = threadPool.submit(task);
        System.out.println(future.get());
    }
}
