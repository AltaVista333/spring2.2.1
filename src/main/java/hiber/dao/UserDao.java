package hiber.dao;

import hiber.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
   void addUser(User user);
   List<User> getAllUsers();
   Optional<User> getUserByCarModelAndSeries(String model, Integer series);
}
