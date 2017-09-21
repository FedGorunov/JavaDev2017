package jdev.server.controllers;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by pinta on 17.07.2017.
 */
@RestController
public class ServerController {
    private Logger logger = LoggerFactory.getLogger(ServerController.class);



    @RequestMapping(value = "/rest/points/create", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    PointDTO createPoint(@RequestBody PointDTO point) {
        logger.info("Start create point");
        String data = "AutoNum: " + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat();
        logger.info(data);
        try (FileWriter writer = new FileWriter("tracks.txt", true)) {
            writer.write(String.valueOf(point) + System.getProperty("line.separator"));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return point;
    }
}