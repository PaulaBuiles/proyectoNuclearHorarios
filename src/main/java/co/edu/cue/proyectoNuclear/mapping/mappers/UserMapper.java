package co.edu.cue.proyectoNuclear.mapping.mappers;


import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /*@Mapping(target = "name", source = "username")
    UserDto mapFrom(User source);*/
}
