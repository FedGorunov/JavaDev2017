package jdev.tracker;

import jdev.tracker.services.DataSendService;
import jdev.tracker.services.DataStorageService;
import jdev.tracker.services.GpsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by Fedor on 11.06.2017.
 */
@Configuration
@EnableScheduling
class QieueContext {
    @Bean
    public DataSendService sendService() {
        return new DataSendService();
    }

    @Bean
    public DataStorageService storageService() {
        return new DataStorageService();
    }

    @Bean
    public GpsService gpsService() {
        return new GpsService();
    }

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(20);
        scheduler.setThreadNamePrefix("task_number");
        return scheduler;
    }
}
