package co.edu.cue.proyectoNuclear.security.impl;

import co.edu.cue.proyectoNuclear.infrastructure.dao.UserDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.security.UserDataSecurity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserDataSecurityImpl implements UserDataSecurity {

    @Autowired
    private final UserDAOImpl userDAO;
    @Override
    public UserDto userSecurity(Long id) {
        return userDAO.findById(id);
    }
}
