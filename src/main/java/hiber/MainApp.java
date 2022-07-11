package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        carService.addCar(new Car("Golf", 1));
        carService.addCar(new Car("Supra", 2));
        carService.addCar(new Car("Lancer", 3));
        carService.addCar(new Car("Mustang", 4));

        List<Car> cars = carService.getAllCars();

        userService.addUser(new User("User1", "Lastname1",
                "user1@mail.ru", cars.get(0)));
        userService.addUser(new User("User2", "Lastname2",
                "user2@mail.ru", cars.get(1)));
        userService.addUser(new User("User3", "Lastname3",
                "user3@mail.ru", cars.get(2)));
        userService.addUser(new User("User4", "Lastname4",
                "user4@mail.ru", cars.get(3)));

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        Optional<User> user = userService.getUserByCarModelAndSeries("Lancer", 3);
        user.ifPresent(System.out::println);
        context.close();
    }
}
