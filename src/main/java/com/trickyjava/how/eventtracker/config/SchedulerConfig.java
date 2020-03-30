package com.trickyjava.how.eventtracker.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableAsync
@Log4j2
public class SchedulerConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegister) {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setErrorHandler(t -> log.error("Caught exception on the @Scheduled task. " + t.getMessage()));
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("Spring-scheduler-task-pool-");
        taskScheduler.initialize();
        scheduledTaskRegister.setTaskScheduler(taskScheduler);
    }

}
