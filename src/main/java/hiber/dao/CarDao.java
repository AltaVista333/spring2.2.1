package hiber.dao;

import hiber.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    void add(Car car);

    List<Car> listCar();

}
