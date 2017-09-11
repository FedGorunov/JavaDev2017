package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.concurrent.BlockingDeque;

import static org.junit.Assert.*;

/**
 * Created by Fedor on 09.09.2017.
 */
public class DataStorageServiceTest {

    private BlockingDeque<PointDTO> que;
    private PointDTO point;
    private DataStorageService service;


    @Before
    public void setUp() throws Exception {
        service = new DataStorageService();

        Field queTest = DataStorageService.class.getDeclaredField("queue");
        queTest.setAccessible(true);
        que = (BlockingDeque<PointDTO>) queTest.get(service);

        point = new PointDTO();
        point.setLon(12);
        point.setLat(24);
        point.setAutoId("NUM");
    }

    @Test
    public void getQueue() throws Exception {

        assertNotNull(service.getQueue());
    }

    @Test
    public void take() throws Exception {
        que.put(point);
        checkup(service.take());
    }

    @Test
    public void put() throws Exception {
        service.put(point);
        checkup(que.take());
    }

    private void checkup(PointDTO checkPoint){
        assertEquals(point.getLon(), checkPoint.getLon(), 0);
        assertEquals(point.getLat(), checkPoint.getLat(), 0);
        assertEquals(point.getAutoId(), checkPoint.getAutoId());

    }

}