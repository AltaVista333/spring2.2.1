package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        List.of(
                new Car("Golf", 1),
                new Car("Supra", 2),
                new Car("Lancer", 3),
                new Car("Mustang", 4))
            .forEach(carService::addCar);

        List<Car> cars = carService.getAllCars();

        List.of(
                new User("User1", "Lastname1", "user1@mail.ru", cars.get(0)),
                new User("User2", "Lastname2", "user2@mail.ru", cars.get(1)),
                new User("User3", "Lastname3", "user3@mail.ru", cars.get(2)),
                new User("User4", "Lastname4", "user4@mail.ru", cars.get(3)))
            .forEach(userService::addUser);

        userService.getAllUsers().forEach(System.out::println);

        Optional<User> user = userService.getUserByCarModelAndSeries("Lancer",
            3);
        user.ifPresent(System.out::println);
        context.close();
    }
}
