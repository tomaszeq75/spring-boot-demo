package pl.sda.springbootdemo.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.springbootdemo.domain.address.Address;
import pl.sda.springbootdemo.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "myusers")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String login;

    private String password;

    @ManyToMany
    @JoinTable(name = "users_addresses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private List<Address> addresses;

}
