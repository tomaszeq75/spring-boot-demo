package pl.sda.springbootdemo.domain.address;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springbootdemo.domain.common.BaseEntity;
import pl.sda.springbootdemo.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "myaddresses")
public class Address extends BaseEntity {

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String postalCode;

    @ManyToMany(mappedBy = "addresses")
    private List<User> users;
}
