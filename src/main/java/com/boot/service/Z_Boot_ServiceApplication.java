package com.boot.service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.boot.service.activemqsender.BootQueueSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableCaching
@EnableRedisHttpSession
@SpringBootApplication
@EnableDubboConfiguration
public class Z_Boot_ServiceApplication {

    public static final Logger logger = LoggerFactory.getLogger(Z_Boot_ServiceApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Z_Boot_ServiceApplication.class, args);
        BootQueueSender sender = (BootQueueSender) context.getBean("bootQueueSender");
        sender.send();
        logger.info("======从QueueDestination发送消息成功======");
    }
}
