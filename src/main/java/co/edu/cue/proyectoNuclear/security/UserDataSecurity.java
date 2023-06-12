package co.edu.cue.proyectoNuclear.security;


import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;

public interface UserDataSecurity {

    UserDto userSecurity(Long id);

}
