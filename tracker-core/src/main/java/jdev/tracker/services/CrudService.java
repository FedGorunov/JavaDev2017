package jdev.tracker.services;

import jdev.tracker.dao.Point;
import jdev.tracker.dao.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fedor on 21.09.2017.
 */
@Service
public class CrudService {
    @Autowired
    PointRepository pointRepository;

    public List<Point> read(){
        List<Point> allPoints = (List<Point>) pointRepository.findAll();
        return allPoints;
    }

    public Point create(Point point) {
        return pointRepository.save(point);
    }

    public void update(Point point) {
        pointRepository.save(point);
    }

    public void delete(Point point) {
        pointRepository.delete(point);
    }
}