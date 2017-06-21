package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private BlockingDeque<PointDTO> queue =  new LinkedBlockingDeque<>(1000);


    public BlockingDeque<PointDTO> getQueue() {
        return queue;
    }

    PointDTO take() throws InterruptedException {
        log.info("take trying!!!");
        return queue.poll(500, TimeUnit.MILLISECONDS);
    }

    void put(PointDTO point) throws InterruptedException {
        log.info("Added to storage: " + point);
        queue.put(point);
    }

}
