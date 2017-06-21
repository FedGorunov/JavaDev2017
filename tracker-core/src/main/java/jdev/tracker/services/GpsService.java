package jdev.tracker.services;

import de.micromata.opengis.kml.v_2_2_0.*;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by Fedor on 11.06.2017.
 */
@Service
public class GpsService {
    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);
    private int putCount;
    @Autowired
    DataStorageService dataStorageService;

    final Kml kml = Kml.unmarshal(new File("tracker-core//src//main//resources//26521.kml"));
    final Placemark placemark = (Placemark) kml.getFeature();
    LineString point = (LineString) placemark.getGeometry();
    List<Coordinate> coordinates = point.getCoordinates();

    @Scheduled(fixedRate = 1_000)
    public void poolGPS() throws InterruptedException {
        int i = putCount++;
        if(i<coordinates.size()){
        PointDTO dto = new PointDTO();
        dto.setAutoId("a001aa");
        dto.setLat(coordinates.get(i).getLatitude());
        dto.setLon(coordinates.get(i).getLongitude());
        dataStorageService.put(dto);}
        else {
            log.info("The track is finished.");

        }
    }

}
