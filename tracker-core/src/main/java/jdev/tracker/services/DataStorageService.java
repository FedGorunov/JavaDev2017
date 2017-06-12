package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fedor on 11.06.2017.
 */
@Service
public class DataStorageService {
    private static final Logger log = LoggerFactory.getLogger(DataStorageService.class);


    private BlockingDeque<PointDTO> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;

    @Scheduled (fixedDelay = 2000)
    void take() throws InterruptedException {
        log.info("take trying!!!");
        long current = System.currentTimeMillis();
        log.info((current - previous) + " ScheduledQueueService.take " + queue.poll(500, TimeUnit.MILLISECONDS));

        previous = current;

    }

    @Scheduled (fixedDelay = 1_000)
    void put() throws InterruptedException {
        int i = putCount++;
        PointDTO dto = new PointDTO();
        dto.setAutoId("a001aa");
        dto.setLat(i);
        dto.setLon(i);
        log.info("ScheduledQueueService.put " + i);
        queue.put(dto);

    }

}
