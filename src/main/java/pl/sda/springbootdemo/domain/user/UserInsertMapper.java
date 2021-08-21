package pl.sda.springbootdemo.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = UserMapper.class)
public interface UserInsertMapper {
    UserInsertMapper INSTANCE = Mappers.getMapper(UserInsertMapper.class);

    UserInsertDTO toDTO(User user);

    User toEntity(UserInsertDTO userInsertDTO);

}
