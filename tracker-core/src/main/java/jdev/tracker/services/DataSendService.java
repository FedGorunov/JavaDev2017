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
    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);

    @Autowired
    DataStorageService dataStorageService;

    @Scheduled(fixedDelay = 60_000)
    private void sendDTO() throws InterruptedException {
        int i=0;
        for (PointDTO p:dataStorageService.getQueue()) {
            log.info(" Point number "+i +": " + p);
            i++;
        }
    }
}
