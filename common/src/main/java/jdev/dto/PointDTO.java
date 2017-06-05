package jdev.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by pinta on 05.06.2017.
 */
public class PointDTO {
    private double lat;
    private double lon;
    private String autoId;

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
                ", autoId='" + autoId + '\'' +
                '}';
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

}
