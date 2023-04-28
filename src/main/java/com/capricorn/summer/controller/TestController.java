package com.capricorn.summer.controller;

import com.capricorn.summer.config.ThreadPoolExecutorConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
@Slf4j
@RequestMapping("test")
@Controller
public class TestController {
    ThreadPoolExecutorConfig threadPoolExecutorConfig;

    @RequestMapping("test")
    public void test(){
        List<String> strings = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        ThreadPoolExecutor executor = threadPoolExecutorConfig.myThreadPoolExecutor();
        long start = System.currentTimeMillis();
        strings.forEach(s -> {
            try {
                Thread.sleep(1000);
                executor.execute(()->{
                    System.out.println(String.format("执行第%s条数据",s));
                });
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        log.info(String.format("执行一轮%s条数据耗时：%s ms",end-start));
    }
}
