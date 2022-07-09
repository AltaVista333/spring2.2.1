package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao dao;

    @Override
    @Transactional
    public void add(Car car) {
        dao.add(car);
    }

    @Override
    @Transactional
    public List<Car> listCars() {
        return dao.listCar();
    }

}
