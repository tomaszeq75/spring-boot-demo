package pl.sda.springbootdemo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pl.sda.springbootdemo.domain.user.*;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
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


}
