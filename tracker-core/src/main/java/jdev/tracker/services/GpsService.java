package jdev.tracker.services;

import de.micromata.opengis.kml.v_2_2_0.*;
import jdev.dto.PointDTO;
import jdev.dto.Points;
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
    private static final Logger log = LoggerFactory.getLogger(GpsService.class);
    private int putCount =0;
    private static final int TIMEOUT = 1_000;
    private  long time = 1_498_998_207_587L;
    double lat, latPrev, lon, lonPrev;
    @Autowired
    DataStorageService dataStorageService;

    final Kml kml = Kml.unmarshal(new File("tracker-core//src//main//resources//26521.kml"));
    final Placemark placemark = (Placemark) kml.getFeature();
    LineString point = (LineString) placemark.getGeometry();
    List<Coordinate> coordinates = point.getCoordinates();

    @Scheduled(fixedRate = TIMEOUT)
    public void poolGPS() throws InterruptedException {
        int i = putCount++;
        if (i < coordinates.size()) {
            PointDTO dto = new PointDTO();
            dto.setAutoId("a001aa");
            latPrev = coordinates.get(i - 1).getLatitude();
            lat = coordinates.get(i).getLatitude();
            lonPrev = coordinates.get(i - 1).getLongitude();
            lon = coordinates.get(i).getLongitude();

            dto.setLat(latPrev);
            dto.setLon(lonPrev);
            time += TIMEOUT;
            dto.setTime(time);
            dto.setCourse(Points.getCourse(latPrev, lat, lonPrev, lon));
            dto.setSpeed(Points.getDistance(latPrev, lat, lonPrev, lon) * 1000 / TIMEOUT);
            dataStorageService.put(dto);
        } else {
            log.info("The track is finished.");

        }
    }
}
