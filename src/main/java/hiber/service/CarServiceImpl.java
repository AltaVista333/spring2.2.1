package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDao dao;

    @Autowired
    public CarServiceImpl(CarDao dao) {
        this.dao = dao;
    }

    @Override
    public void addCar(Car car) {
        dao.addCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return dao.listCar();
    }

}
