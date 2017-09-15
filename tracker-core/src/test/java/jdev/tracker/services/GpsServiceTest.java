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
        dataStorageService = new DataStorageService();
        gpsService = new GpsService(dataStorageService);
    }

    @Test
    public void poolGPS() throws Exception {
    coordinates = gpsService.createCoordinates("26521.kml");
    gpsService.setCoordinates(coordinates);
    for (int i=0; i<10; i++){
    gpsService.poolGPS();}
    assertNotNull(dataStorageService.getQueue());
    assertEquals(10, dataStorageService.getQueue().size());

    }

    @Test
    public void createCoordinates(){
      coordinates =  gpsService.createCoordinates("26521.kml");
      assertEquals(643, coordinates.size());
      assertEquals(56.487526, coordinates.get(0).getLatitude(), 0);
      assertEquals(84.959198, coordinates.get(0).getLongitude(), 0);
    }

}