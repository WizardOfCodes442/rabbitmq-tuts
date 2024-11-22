package com.sp3.rabbitmqtuts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RabbitAmqpTutorialRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RabbitAmqpTutorialRunner.class);

    @Value("${tutorial.client.duration:0}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        if (duration < 0) {
            log.warn("Duration cannot be negative. Exiting.");
            ctx.close();
            return;
        }

        log.info("Ready... Running for {} ms", duration);
        Thread.sleep(duration);
        log.info("Shutting down application context.");
        ctx.close();
    }
}
