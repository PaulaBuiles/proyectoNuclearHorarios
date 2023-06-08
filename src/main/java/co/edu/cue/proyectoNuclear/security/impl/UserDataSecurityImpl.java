package co.edu.cue.proyectoNuclear.security.impl;

import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.security.UserDataSecurity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserDataSecurityImpl implements UserDataSecurity {
    @Override
    public User userSecurity(Long id) {
        return null;
    }
}
