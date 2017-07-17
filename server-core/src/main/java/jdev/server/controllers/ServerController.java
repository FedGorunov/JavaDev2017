package jdev.server.controllers;

import jdev.dto.PointDTO;
import jdev.server.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pinta on 17.07.2017.
 */
@RestController
public class ServerController {
    Logger logger = LoggerFactory.getLogger(ServerController.class);

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/rest/points/create", method = RequestMethod.POST)
    public @ResponseBody
    PointDTO createPoint(@RequestBody PointDTO point) {
        logger.info("Start create point");
        String data = "AutoNum: " + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat();
        logger.info(data);
        fileService.writeInFile(data);
        return point;
    }
}