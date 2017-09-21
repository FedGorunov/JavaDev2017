package jdev.tracker.dao;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * Created by Fedor on 18.09.2017.
 */
@Entity
@Table(name = "points")
public class Point {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "LATITUDE")
    private double lat;
    @Column(name = "LONGITUDE")
    private double lon;
    @Column(name = "SPEED")
    private double speed; // current speed (km/h)
    @Column(name = "COURSE")
    private double course; // current car course ( rad)
    @Column(name = "TIME")
    private long time;      // current time (msec)
    @Column(name = "AUTO_ID")
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
