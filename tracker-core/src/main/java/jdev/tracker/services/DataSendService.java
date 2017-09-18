package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fedor on 11.06.2017.
 */
@Service
public class DataSendService {
    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);
    private static final int TIME_OUT = 10_000;

    @Autowired
    DataStorageService dataStorageService;


   // RestTemplate restTemplate = new RestTemplate();

    @Autowired
    RestTemplate restTemplate;


    @Scheduled(fixedDelay = TIME_OUT)
    public List<PointDTO> sendDTO() throws InterruptedException {
        List<PointDTO> list = new ArrayList<>();
        int i=0;
       for (PointDTO p:dataStorageService.getQueue()) {
            log.info(" Point number "+i +": " + p);
          list.add(restTemplate.postForObject("http://localhost:8080/rest/points/create", p, PointDTO.class));

          i++;
        }
        return list;
    }
}
