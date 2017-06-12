package jdev.tracker.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Fedor on 11.06.2017.
 */
@Service
public class DataSendService {
    @Scheduled(fixedDelay = 1_000)
    private void sendDTO(){
    }


}
