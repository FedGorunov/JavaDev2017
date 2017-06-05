package jdev.dto;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by pinta on 05.06.2017.
 */
public class PointDTOTest {
    @Test
    public void toJson() throws Exception {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLat(75);
        pointDTO.setLon(75);
        pointDTO.setAutoId("a856op");
        assertTrue(pointDTO.toJson().contains("\"lat\":75"));
        System.out.println(pointDTO.toJson());
    }
}
