package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    Boolean validateUser(Long id, String password);
    UserDto getUser();
    List<UserDto> getUsers();
}
