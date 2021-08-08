package pl.sda.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springbootdemo.domain.user.User;
import pl.sda.springbootdemo.domain.user.UserService;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

    private final UserService userService;


    public SpringBootDemoApplication(UserService userService) {
        this.userService = userService;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jan", "Kowalski", "janko", "", true);

        System.out.println(userService.save(user));
    }

}
