package jdev.tracker.dao.repo;

import jdev.tracker.dao.Point;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fedor on 21.09.2017.
 */
public interface PointRepository extends CrudRepository<Point, Integer> {
}
