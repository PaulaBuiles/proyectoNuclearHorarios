package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.entities.Usuario;
import co.edu.cue.proyectoNuclear.infrastructure.dao.GeneralDAO;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final GeneralDAO userDAO;

    private final UserMapper mapper;
    /*@Override
    public List<Usuario> getAllUsers() {

        System.out.println(userDAO.getStudents().parallelStream()
                .map(e->mapper.mapFrom(e))
                .toList());

        return userDAO.getUsuarios();
       // return new ArrayList<String>(List.of("Monica", "Paula", "Andres"));
    }*/

    @Override
    public String getUserByName(String name) {
        return "Monica Lorena Tobon";
    }
}
