package com.capricorn.summer.job.handle;

import com.capricorn.summer.job.annotation.SyncJob;
import com.capricorn.summer.mapper.BecomingRichMapper;
import com.capricorn.summer.utils.BecomingRichUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@SyncJob(corn = "0 */1 * * * ? *",triggerName = "testTrigger",jobName = "testJob")
public class TestJob implements Job, JobListener {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;
    @Autowired
    private BecomingRichMapper mapper;
    @Value("${IP}")
    private String IP;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = format.format(new Date());
        System.out.println("测试任务:"+nowDate);
        long start = System.currentTimeMillis();
        mapper.delAll();
        List<Map<String, Object>> allFundCode = mapper.findAllFundCode();
        //单线程
        allFundCode.forEach(fundCode -> {
//            String fund_code = BecomingRichUtil.request(fundCode.get("FUND_CODE").toString(),IP);
            String fund_code = BecomingRichUtil.req(fundCode.get("FUND_CODE").toString(), IP);
            Map<String, Object> map = BecomingRichUtil.regular(fund_code,fundCode.get("IF_BUY").toString());

            mapper.handle(map);
        });
        //并行流
//        allFundCode.parallelStream().forEach(fund ->{
//            String fund_code = BecomingRichUtil.request(fund.get("FUND_CODE").toString());
//            Map<String, Object> map = BecomingRichUtil.regular(fund_code);
//            mapper.handle(map);
//        });
        long end = System.currentTimeMillis();
        log.info(String.format("执行一轮%s条数据耗时：%s ms",allFundCode.size(),end-start));

    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {

    }


    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
    }
}
