package pl.sda.springbootdemo.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.sda.springbootdemo.domain.role.RoleMapper;

@Mapper(uses = {UserMapper.class, RoleMapper.class})
public interface UserInsertMapper {
    UserInsertMapper INSTANCE = Mappers.getMapper(UserInsertMapper.class);

    UserInsertDTO toDTO(User user);

    User toEntity(UserInsertDTO userInsertDTO);

}
