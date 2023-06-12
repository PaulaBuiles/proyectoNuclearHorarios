package co.edu.cue.proyectoNuclear.services.impl;


import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.infrastructure.dao.ScheduleDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.TeacherDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.UserDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.*;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@AllArgsConstructor // Anotación de Lombok para generar automáticamente un constructor que acepta todos los campos
@Service // Anotación de Spring para marcar esta clase como un componente de servicio
public class UserServiceImpl implements UserService {

    private static UserDto user1; // Variable estática para almacenar el usuario

    @Autowired // Inyección de dependencias de UserDAOImpl
    public UserDAOImpl userGeneralDAO;

    @Autowired // Inyección de dependencias de TeacherDAOImpl
    public TeacherDAOImpl teacherDAO;

    @Autowired // Inyección de dependencias de ScheduleDAOImpl
    public ScheduleDAOImpl scheduleDAO;

    @Override
    public List<ScheduleDto> getUserSchedule(List<Subject> subjects) {
        List<ScheduleDto> allSchedules = scheduleDAO.getTableList();
        List<ScheduleDto> userSchedules = new ArrayList<>();

        for (ScheduleDto schedule : allSchedules) {
            for (Subject subject : subjects) {
                if (schedule.subject().getId().equals(subject.getId())) {
                    userSchedules.add(schedule);
                }
            }
        }
        return userSchedules; // Obtener los horarios del usuario para las asignaturas dadas
    }

    @Override
    public Boolean validateUser(Long id, String password) {
        List<UserDto> userList = userGeneralDAO.getTableList();
        Boolean band = false;

        for (UserDto user : userList) {
            if (id.equals(user.id()) && password.equals(user.password())) {
                band = true;
                user1 = user;
                System.out.println(user1.name());
                break;
            }
        }
        return band; // Validar si el ID y la contraseña coinciden con un usuario existente
    }

    public List<UserDto> getUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserDto userDto : userGeneralDAO.getTableList()) {
            if (userDto.id() == 0) {
                System.out.println("Null");
            } else {
                userDtoList.add(userDto);
            }
        }
        return userDtoList; // Obtener la lista de usuarios
    }

    public UserDto getUser() {
        return user1; // Obtener el usuario actual
    }

    public List<UserDto> filterUsersByRole(String role) {
        System.out.println("entre");
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserDto userDto : userGeneralDAO.getTableList()) {
            if (role.equals("Todos") && userDto.id() != 0) {
                userDtoList.add(userDto);
            } else if (userDto.role().equals(role)) {
                userDtoList.add(userDto);

            }
        }
        return userDtoList; // Filtrar usuarios por rol
    }

    @Override
    public List<LocalTime> getHoursList() {
        List<LocalTime> hours = Arrays.asList(
                LocalTime.parse("07:00"), LocalTime.parse("08:00"), LocalTime.parse("09:00"), LocalTime.parse("10:00"), LocalTime.parse("11:00"), LocalTime.parse("12:00"),
                LocalTime.parse("13:00"), LocalTime.parse("14:00"), LocalTime.parse("15:00"), LocalTime.parse("16:00"), LocalTime.parse("17:00"), LocalTime.parse("18:00"),
                LocalTime.parse("19:00"), LocalTime.parse("20:00"), LocalTime.parse("21:00"), LocalTime.parse("22:00")
        );
        return hours; // Obtener una lista de horas
    }

    public List<String> getDaysList() {
        List<String> days = Arrays.asList(
                "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
        );
        return days; // Obtener una lista de días
    }

    @Override
    public void deleteById(Long idUser) {
        userGeneralDAO.delete(idUser); // Eliminar un usuario por su ID
    }
}
