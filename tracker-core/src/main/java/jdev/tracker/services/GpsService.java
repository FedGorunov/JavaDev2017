package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Fedor on 11.06.2017.
 */
@Service
public class GpsService {
    @Scheduled(fixedDelay = 1_000)
    public PointDTO getDTO(){
        return new PointDTO();
    }

}
