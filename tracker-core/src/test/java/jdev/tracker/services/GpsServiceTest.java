package jdev.tracker.services;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Fedor on 09.09.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class GpsServiceTest {
    private List<Coordinate> coordinates;
    private DataStorageService dataStorageService;
    private GpsService gpsService;

    @Before
    public void setUp() throws Exception {
        coordinates= new ArrayList<Coordinate>();
        Coordinate coordinate1 = new Coordinate(10, 10);
        Coordinate coordinate2 = new Coordinate(10.1, 10.1);
        coordinates.add(coordinate1);
        coordinates.add(coordinate2);
        dataStorageService = new DataStorageService();
        gpsService = new GpsService();

    }

    @Test
    public void poolGPS() throws Exception {
    when(coordinates).thenReturn(coordinates);
    gpsService.poolGPS();
    }

}