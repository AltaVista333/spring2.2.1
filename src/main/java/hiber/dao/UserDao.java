package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUserByCarModelAndSeries(String model, Integer series);
}
