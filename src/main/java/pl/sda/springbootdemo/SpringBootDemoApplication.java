package pl.sda.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springbootdemo.domain.address.Address;
import pl.sda.springbootdemo.domain.address.AddressRepository;
import pl.sda.springbootdemo.domain.address.AddressService;
import pl.sda.springbootdemo.domain.user.User;
import pl.sda.springbootdemo.domain.user.UserService;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

    private final UserService userService;
    private final AddressService addressService;

    public SpringBootDemoApplication(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Address address1 = new Address("Lodz", "Krotka 15", "90-050");
        Address address2 = new Address("Lodz", "Długa 15", "90-047");



        User user = new User("Janusz", "Kowal", "jankow", "", true);
        user.getAddresses().addAll(Arrays.asList(addressService.save(address1), addressService.save(address2)));

        System.out.println(userService.save(user));
    }

}
