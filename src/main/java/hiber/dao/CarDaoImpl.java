package hiber.dao;

import hiber.model.Car;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> getAllCars() {
        Session session = sessionFactory.openSession();
        List<Car> resultList = session.createQuery("from Car").getResultList();
        session.close();
        return resultList;

    }

}
