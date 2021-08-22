package pl.sda.springbootdemo.domain.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import pl.sda.springbootdemo.domain.address.Address;
import pl.sda.springbootdemo.domain.address.AddressRepository;
import pl.sda.springbootdemo.domain.role.RoleRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, AddressRepository addressRepository, BCryptPasswordEncoder encoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public User save(User user) {
        List<Address> addresses = user.getAddresses();
        if (!CollectionUtils.isEmpty(addresses)) {
            List<Address> savedAddresses = addressRepository.saveAll(addresses);
            user.setAddresses(savedAddresses);
        }
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        Long roleId = savedUser.getRole().getId();
        savedUser.setRole(roleRepository.getById(roleId));
        return savedUser;
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

    public Authentication getLoggedUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
