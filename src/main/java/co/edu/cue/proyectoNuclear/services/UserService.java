package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Usuario;

import java.util.List;

public interface UserService {

    List<Usuario> getAllUsers();
    String getUserByName(String name);

}
