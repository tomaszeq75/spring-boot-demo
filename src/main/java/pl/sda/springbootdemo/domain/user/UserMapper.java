package pl.sda.springbootdemo.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sda.springbootdemo.domain.address.AddressMapper;
import pl.sda.springbootdemo.domain.role.RoleMapper;

@Mapper(uses = {AddressMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

}
