package jdev.tracker.services;

import de.micromata.opengis.kml.v_2_2_0.*;
import jdev.dto.PointDTO;
import jdev.dto.Points;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

/**
 * Created by Fedor on 11.06.2017.
 */
@Service
public class GpsService {
    private static final Logger log = LoggerFactory.getLogger(GpsService.class);
    private int poolCount =0;
    private List<Coordinate> coordinates;
    private static final int TIMEOUT = 1_000;
    private  long time;
    double lat =0, latPrev=0, lon=0, lonPrev=0;


    private final DataStorageService dataStorageService;

    public GpsService(@Autowired DataStorageService dataStorageService) {
        this.dataStorageService = dataStorageService;
    }

    @Value("${autoNum}")
    private String autoId;

    @Value("${kmlFileName}")
    private String kmlFileName;



    @PostConstruct
    private void init(){
        coordinates = createCoordinates(kmlFileName);
    }

    @Scheduled(fixedRate = TIMEOUT)
    public void poolGPS() {
        if (coordinates.iterator().hasNext()) {
            Coordinate coordinate = coordinates.iterator().next();
            PointDTO dto = new PointDTO();
            dto.setAutoId(autoId);
            time= System.currentTimeMillis();
            dto.setTime(time);
            lat = coordinate.getLatitude();
            lon = coordinate.getLongitude();
            dto.setLat(lat);
            dto.setLon(lon);
            dto.setCourse(Points.getCourse(latPrev, lat, lonPrev, lon));
            dto.setSpeed(Points.getDistance(latPrev, lat, lonPrev, lon) * 1000 / TIMEOUT);
            try {
                dataStorageService.put(dto);
                log.info("Gps point num: " + poolCount + " Time " + time);
                coordinates.remove(coordinate);
                latPrev =lat;
                lonPrev =lon;
                poolCount++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            log.info("The track is over.");

        }
    }

    public List<Coordinate> createCoordinates(String kmlFile){
        final Kml kml = Kml.unmarshal(new File(getClass().getClassLoader().getResource(kmlFile).getFile()));
        final Placemark placemark = (Placemark) kml.getFeature();
        LineString point = (LineString) placemark.getGeometry();
        return  point.getCoordinates();
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}
