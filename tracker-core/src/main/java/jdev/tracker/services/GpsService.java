package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Fedor on 11.06.2017.
 */
@Service
public class GpsService {
    private int putCount;
    @Autowired
    DataStorageService dataStorageService;

    @Scheduled(fixedDelay = 1_000)
    public void poolGPS() throws InterruptedException {
        int i = putCount++;
        PointDTO dto = new PointDTO();
        dto.setAutoId("a001aa");
        dto.setLat(i);
        dto.setLon(i);
        dataStorageService.put(dto);
    }

}
