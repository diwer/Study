package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryListener;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.stats.DefaultStatisticsRepository;
import org.springframework.retry.stats.StatisticsListener;
import org.springframework.retry.support.RetryTemplate;

import java.util.Random;

@SuppressWarnings("AlibabaClassMustHaveAuthor")
@SpringBootApplication
/**
 * @author hello
 */
public class DemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) throws Throwable {

        int count = 10000;
        for (int i = 0; i < count; i++) {
            LOGGER.debug("start");
            LOGGER.info("run");
            LOGGER.error("end");
            Thread.sleep(1000);
        }


//        String str = new String("ewesdfsdfhalskdfjhaskljfhasdklfhaksjdfhaksjdhfaksldjfhaklsdjfhaskdjfhaskldjfhaskdjfhask");
//
//        while (true) {
//            Thread.sleep(2000);
//            System.out.println(str);
//            str = str + str;
//        }
        // testRetry();
        //SpringApplication.run(DemoApplication.class, args);
    }

    static Random random = new Random();

    public static void testRetry() throws Throwable {
        RetryTemplate template = new RetryTemplate();
        RetryCallback<String, Throwable> retryCallback = context -> remoteInvoke();
        RecoveryCallback<String> recoveryCallback = context -> {
            System.out.println("recovery");
            return "recovery";
        };
        // 设置回避策略
        template.setBackOffPolicy(new FixedBackOffPolicy());
        // 设置策略
        template.setRetryPolicy(new SimpleRetryPolicy());
        // 设置listener
        template.setListeners(new RetryListener[]{new StatisticsListener(new DefaultStatisticsRepository())});
        // 执行模板
        template.execute(retryCallback, recoveryCallback);
    }

    private static String remoteInvoke() {
        //if (random.nextBoolean()) {
        throw new IllegalArgumentException();
        //}
        //return "success";
    }
}
