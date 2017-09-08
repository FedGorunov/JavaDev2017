package jdev.dto;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Fedor on 12.08.2017.
 */
public class PointsTest {
    @Test
    public void getDistance() throws Exception {
      double distance = Points.getDistance(77.1539, -77.1804, -139.398, -139.55 );
      assertEquals(17166029, distance, 1);

    }

    @Test
    public void getCourse() throws Exception {
        PointDTO point1 = new PointDTO();
        PointDTO point2 = new PointDTO();
        point1.setLat(77.1539);
        point2.setLat(-77.1804);
        point1.setLon(-139.398);
        point2.setLon(-139.55);
        double course = Points.getCourse(77.1539, -77.1804, -139.398, -139.55);
        assertEquals(180.077867811, course, 0.00001);
    }

    @Test
    public void getSpeed() throws Exception {PointDTO point1 = new PointDTO();
        PointDTO point2 = new PointDTO();
        point1.setLat(77.1539);
        point2.setLat(-77.1804);
        point1.setLon(-139.398);
        point2.setLon(-139.55);
        point1.setTime(1_150_000_000);
        point2.setTime(1_250_000_000);
        double speed = Points.getSpeed(point1, point2);
        assertEquals(171.66029, speed, 0.1);
    }

}