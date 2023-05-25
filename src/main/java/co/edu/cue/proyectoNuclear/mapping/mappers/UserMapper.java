package co.edu.cue.proyectoNuclear.mapping.mappers;


import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto mapUser(User source);
    User mapToEntity(UserDto source);
    List<UserDto> mapList(List<User> source);
}
