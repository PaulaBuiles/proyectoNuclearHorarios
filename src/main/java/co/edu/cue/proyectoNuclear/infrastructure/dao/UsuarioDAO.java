package co.edu.cue.proyectoNuclear.infrastructure.dao;


import co.edu.cue.proyectoNuclear.domain.entities.Usuario;

import java.util.List;

public interface UsuarioDAO {
    List<Usuario> getUsuarios();
}
