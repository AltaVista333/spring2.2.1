/* (C)2022 */
package hiber.dao;

import hiber.model.User;
import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> resultList = session.createQuery("from User")
            .getResultList();
        session.close();
        return resultList;
    }

    @Override
    public Optional<User> getUserByCarModelAndSeries(String model,
        Integer series) {
        Session session = sessionFactory.openSession();
        TypedQuery<User> query =
            session.createQuery(
                "from User where car.model = :model and car.series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        Optional<User> user = Optional.ofNullable(query.getSingleResult());
        session.close();
        return user;
    }
}
