package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void addUser(User user) {
      userDao.addUser(user);
   }

   @Override
   public List<User> getAllUsers() {
      return userDao.getAllUsers();
   }

   @Override
   public User getUserByCarModelAndSeries(String model, Integer series) {
      return userDao.getUserByCarModelAndSeries(model, series);
   }

}
