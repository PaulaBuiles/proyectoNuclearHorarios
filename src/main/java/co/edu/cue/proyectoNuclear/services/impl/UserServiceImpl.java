package co.edu.cue.proyectoNuclear.services.impl;


import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.infrastructure.dao.TeacherDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.UserDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static UserDto user1;
    @Autowired
    public UserDAOImpl userGeneralDAO;
    @Autowired
    public TeacherDAOImpl teacherDAO;
    @Autowired
    public TeacherService teacherService;
    @Autowired
    public StudentService studentService;
    @Autowired
    public AdministrativeService administrativeService;
    private final List<UserDto> userService;



    @Override
    public Boolean validateUser(Long id, String password) {

        List<UserDto> userList = userGeneralDAO.getTableList();
        Boolean band = false;
        for (UserDto user: userList) {
            if (id.equals(user.id()) && password.equals(user.password())) {
                band = true;
                user1 = user;
                System.out.println(user1.name());
                break;
            }
        }
        return band;
    }

    public List<UserDto> getUsers(){
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserDto userDto:userGeneralDAO.getTableList()) {
            if (userDto.id() == 0){
                System.out.println("Null");
            }else {
                userDtoList.add(userDto);
            }
        }
        return userDtoList;
    }


    public UserDto getUser() {
        return user1;
    }

    public List<UserDto> filterUsersByRole(String role){
        System.out.println("entre");
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserDto userDto:userGeneralDAO.getTableList()) {
            if (role.equals("Todos") && userDto.id() != 0){
                userDtoList.add(userDto);
            } else if (userDto.role().equals(role)){
                userDtoList.add(userDto);
                System.out.println("añadido");
            }
        }
        return userDtoList;
    }

}
