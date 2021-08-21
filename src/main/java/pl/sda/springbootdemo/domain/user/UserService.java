package pl.sda.springbootdemo.domain.user;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import pl.sda.springbootdemo.domain.address.Address;
import pl.sda.springbootdemo.domain.address.AddressRepository;

import java.util.Collection;
import java.util.List;

public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public User save(User user) {
        List<Address> addresses = user.getAddresses();
        if (!CollectionUtils.isEmpty(addresses)) {
            List<Address> savedAddresses = addressRepository.saveAll(addresses);
            user.setAddresses(savedAddresses);
        }
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User getByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public List<User> getByLastName(String lastName) {
        return userRepository.getUserByLastName(lastName);
    }

    public User fingByLoginWithAddresses(String login) {
        return userRepository.getUserFetchJoinAddresses(login);
    }

    public User findById(Long id) {
        return userRepository.getById(id);
    }

}
