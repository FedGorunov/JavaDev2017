package jdev.server.controllers;

import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by Fedor on 02.08.2017.
 */

public class ServerControllerTest {



    private PointDTO pointDTO;

    @Before
    public void setUp(){
        pointDTO = new PointDTO();
        pointDTO.setLon(15);
        pointDTO.setLat(25);
        pointDTO.setSpeed(350);
        pointDTO.setAutoId("NUM");
    }


    @Test
    public void createPointIntegration() throws Exception {
        PointDTO result = new ServerController().createPoint(pointDTO);
        assertNotNull(result);
        assertEquals(result.getAutoId(),"NUM");
        assertEquals(result.getLat(),25, 0);
        assertEquals(result.getLon(),15, 0);
        assertEquals(result.getSpeed(),350, 0);
    }

}