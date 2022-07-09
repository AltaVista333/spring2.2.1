package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        carService.add(new Car("Golf", 1));
        carService.add(new Car("Supra", 2));
        carService.add(new Car("Lancer", 3));
        carService.add(new Car("Mustang", 4));

        List<Car> cars = carService.listCars();

        userService.add(new User("User1", "Lastname1",
                "user1@mail.ru", cars.get(0)));
        userService.add(new User("User2", "Lastname2",
                "user2@mail.ru", cars.get(1)));
        userService.add(new User("User3", "Lastname3",
                "user3@mail.ru", cars.get(2)));
        userService.add(new User("User4", "Lastname4",
                "user4@mail.ru", cars.get(3)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        User lancer = userService.getUserByCarModelAndSeries("Lancer", 3);
        System.out.println(lancer);

        context.close();
    }
}
