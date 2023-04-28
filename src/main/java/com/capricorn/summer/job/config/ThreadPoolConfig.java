package com.capricorn.summer.job.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    private final ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(100);
    private final int corePoolSize = 5;
    private final int maximumPoolSize = 5;
    private final int keepAliveTime = 5;
    private final  TimeUnit unit = TimeUnit.SECONDS;

    @Bean
    public ThreadPoolExecutor myThreadPoolExecutor(){
        return new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,arrayBlockingQueue);
    }
}
