package jdev.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by pinta on 05.06.2017.
 */
public class PointDTOTest {
    private String expected = "{\"lat\":75.0,\"lon\":57.0,\"autoId\":\"a856op\"}";
    private String autoaId = "a856op";
    private double lon = 57.0;
    private double lat = 75.0;

    @Test
    public void toJson() throws Exception {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLat(75);
        pointDTO.setLon(57);
        pointDTO.setAutoId("a856op");
        assertTrue(pointDTO.toJson().contains("\"lat\":75"));
        System.out.println(pointDTO.toJson());
    }
    @Test
    public void decodeDTO() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        PointDTO dto = mapper.readValue(expected, PointDTO.class);
        assertEquals(autoaId, dto.getAutoId());
        assertEquals(lon, dto.getLon(), 0);
        assertEquals(lat, dto.getLat(), 0);
    }
}
