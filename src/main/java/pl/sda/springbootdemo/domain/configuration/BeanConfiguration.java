package pl.sda.springbootdemo.domain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.sda.springbootdemo.domain.address.AddressRepository;
import pl.sda.springbootdemo.domain.user.UserRepository;
import pl.sda.springbootdemo.domain.user.UserService;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService getUserService(UserRepository userRepository, AddressRepository addressRepository, BCryptPasswordEncoder encoder) {
        return new UserService(userRepository, addressRepository, encoder);
    }
}
