package pl.sda.springbootdemo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.sda.springbootdemo.domain.user.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        log.info("logged user: " +  userService.getLoggedUser());
        User user = userService.findById(id);
        return UserMapper.INSTANCE.toDTO(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping
    public UserInsertDTO insert(@RequestBody UserInsertDTO userDTO) {
        User user = userService.save(UserInsertMapper.INSTANCE.toEntity(userDTO));
        return UserInsertMapper.INSTANCE.toDTO(user);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')") // zastępuje .antMatchers(HttpMethod.GET, "/users").hasAuthority("ADMIN") w SecurityConfiguration
    public List<UserDTO> getAll() {
        log.info("logged user: " +  userService.getLoggedUser());
        List<User> allUsers = userService.getAll();
        return allUsers.stream()
                .map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }


}
