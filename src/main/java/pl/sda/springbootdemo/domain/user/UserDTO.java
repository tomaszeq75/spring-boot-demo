package pl.sda.springbootdemo.domain.user;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springbootdemo.domain.address.AddressDTO;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private String firstName;
    private String lastName;
    private String login;
    private boolean active;

    private List<AddressDTO> addresses;

}
