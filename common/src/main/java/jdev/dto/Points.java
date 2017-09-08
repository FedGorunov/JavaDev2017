package jdev.dto;

import static java.lang.Math.*;

/**
 * Created by Fedor on 11.08.2017.
 */
public class Points {

    private static final double EARTH_RADIUS = 6372795;
    private static final double PI = Math.PI;

    // Returns the distance between points1, points2 in meters
    public static double getDistance(double latDeg1, double latDeg2, double lonDeg1, double lonDeg2){
        double lat1 = toRadians(latDeg1);
        double lat2 = toRadians(latDeg2);
        double lon1 = toRadians(lonDeg1);
        double lon2 = toRadians(lonDeg2);

        double distance = EARTH_RADIUS * 2 *
                asin(
                        sqrt(
                                pow(sin((lat1 - lat2) / 2), 2) +
                                        cos(lat1) * cos(lat2) *
                                                pow(sin((lon1 - lon2) / 2), 2)
                        )
                );


        return distance;
    }

    //Returns the car course - azimuth at point1 in degrees
    public static double getCourse(double latDeg1, double latDeg2, double lonDeg1, double lonDeg2) {
        double lat1 = toRadians(latDeg1);
        double lat2 = toRadians(latDeg2);
        double lon1 = toRadians(lonDeg1);
        double lon2 = toRadians(lonDeg2);

        double x = cos(lat1) * sin(lat2) -
                sin(lat1) * cos(lat2) * cos(lon2 - lon1);
        double y = sin(lon2 - lon1) * cos(lat2);
        double course = toDegrees(atan(-y / x));

        if (x < 0) course = course + 180;
        course = -toRadians(((course + 180) % 360) - 180);
        course = toDegrees(course - (2 * PI * floor(course / (2 * PI))));
        return course;

    }
    // Returns the car speed in meters/sec
    public static double getSpeed(PointDTO point1, PointDTO point2){

        return getDistance(point1.getLat(), point2.getLat(), point1.getLon(), point2.getLon()) /((point2.getTime() - point1.getTime())/1000);
    }

}
