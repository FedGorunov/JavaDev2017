package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import static org.mockito.Mockito.when;

/**
 * Created by Fedor on 09.09.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DataSendServiceTest {
    private PointDTO p;
    private BlockingDeque<PointDTO> que;
    @Mock
    RestTemplate restTemplate;
    @Mock
    DataStorageService dataStorageService;

    @InjectMocks
    private DataSendService service;

    @Before
    public void setUp(){
        que = new LinkedBlockingDeque<>(10);
        for (int i = 0; i<9; i++){
        p = new PointDTO();
        p.setAutoId("NUM"+i);
        p.setLat(12+i);
        p.setLon(32+i);
        que.add(p);}
    }

    @Test
    public void sendDTO() throws Exception {
        when(dataStorageService.getQueue()).thenReturn(que);
        when( restTemplate.postForObject("http://localhost:8080/rest/points/create", p, PointDTO.class)).thenReturn(p);
        service.sendDTO();
    }
}