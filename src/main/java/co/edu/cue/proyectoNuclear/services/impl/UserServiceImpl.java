package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.infrastructure.dao.GeneralDAO;
import co.edu.cue.proyectoNuclear.infrastructure.dao.UserDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AdministrativeMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static UserDto user1;
    @Autowired
    public UserDAOImpl userGeneralDAO;
    private final List<UserDto> userService;



    @Override
    public Boolean validateUser(Long id, String password) {

        List<UserDto> userList = userGeneralDAO.getTableList();
        Boolean band = false;
        for (UserDto user: userList) {
            System.out.println(user.id());
            if (id.equals(user.id()) && password.equals(user.password())) {
                band = true;
                user1 = user;
                break;
            }
        }
        return band;
    }

    public List<UserDto> getUsers(){
        return userGeneralDAO.getTableList();
    }


    public UserDto getUser() {
        return user1;
    }

}
