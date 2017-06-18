package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Fedor on 11.06.2017.
 */
@Service
public class DataSendService {
    private static final Logger log = LoggerFactory.getLogger(DataStorageService.class);
    private long current = System.currentTimeMillis();
    private long previous;


    @Autowired
    DataStorageService dataStorageService;

    @Scheduled(fixedDelay = 1_000)
    private void sendDTO() throws InterruptedException {
       PointDTO dto = dataStorageService.take();
        log.info((current - previous) + " ScheduledQueueService.take " + dto);
        previous = current;
    }


}
