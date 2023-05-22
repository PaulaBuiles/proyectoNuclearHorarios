package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.entities.Usuario;

import java.util.List;

public interface UserService {
    Boolean validateUser(String user, String password);
    User getUser();

    List<User> generateUsers();
}
