package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.entities.Usuario;
import co.edu.cue.proyectoNuclear.infrastructure.dao.GeneralDAO;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private static User user1 = new User();
    private final GeneralDAO<User> userService;


    @Override
    public Boolean validateUser(String identification, String password) {
        List<User> userList = generateUsers();
        Boolean band = false;
        for (User user: userList) {
            if (identification.equals(user.getIdentification()) && password.equals(user.getPassword())) {
                band = true;
                user1 = user;
                break;
            }
        }
        return band;
    }


    public User getUser() {
        System.out.printf(user1.toString());
        return user1;
    }

    @Override
    public List<User> generateUsers(){
        List<User> userList = new ArrayList<>();
        String[] roles = {"Student", "Teacher", "Administrative"};
        int roleIndex = 0;

        // Crear 10 usuarios y agregarlos a la lista
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setIdentification(String.valueOf(i));
            user.setName("User_" + i);
            user.setEmail("user" + i + "@example.com");
            user.setPassword(String.valueOf(i));
            user.setRole(roles[roleIndex]);

            userList.add(user);

            // Cambiar el índice del rol para que vaya variando en cada iteración
            roleIndex = (roleIndex + 1) % roles.length;
        }
        return userList;
    }

}
