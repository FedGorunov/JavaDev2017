package jdev.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by pinta on 05.06.2017.
 */
public class PointDTO {
    private double lat;
    private double lon;
    private double speed; // current speed (km/h)
    private double course; // current car course ( rad)
    private long time;      // current time (msec)
    private String autoId;

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getSpeed() {
        return speed;
    }

    public double getCourse() {
        return course;
    }

    public long getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    @Override
    public String toString() {
        return "PointDTO{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", course='" + course + '\'' +
                ", speed'" + speed + '\'' +
                ", autoId='" + autoId + '\'' +
                '}';
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

}
