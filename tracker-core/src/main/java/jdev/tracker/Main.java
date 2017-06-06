package jdev.tracker;


import jdev.dto.PointDTO;

/**
 * Created by pinta on 05.06.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        for (int i=0; i<5; i++) {
            System.out.println("Main from tracker-core say Hello!!!!");
            PointDTO point = new PointDTO();
            point.setLat(45);
            System.out.println(point.toJson());
            Thread.sleep(1000);
        }

    }
}
