package pl.sda.springbootdemo.domain.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private String city;
    private String street;
    private String postalCode;

}
