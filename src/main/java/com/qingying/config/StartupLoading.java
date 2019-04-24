package com.qingying.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author Elephant
 * @Date 2019/4/23 23:50
 */
@Component
public class StartupLoading implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartupLoading.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("初始化定时任务start....");
        logger.info("初始化定时任务end....");
    }
}
