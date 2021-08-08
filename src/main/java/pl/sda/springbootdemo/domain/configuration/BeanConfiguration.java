package pl.sda.springbootdemo.domain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.springbootdemo.domain.user.UserRepository;
import pl.sda.springbootdemo.domain.user.UserService;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService getUserService(UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
