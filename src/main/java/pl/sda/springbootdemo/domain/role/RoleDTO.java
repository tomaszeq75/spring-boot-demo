package pl.sda.springbootdemo.domain.role;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springbootdemo.domain.user.User;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class RoleDTO {
    private Long id;
    private String name;
    private String description;
}
