package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.mapping.dtos.ScheduleDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;


@Service
public interface UserService {
    List<ScheduleDto> getUserSchedule(List<Subject> subjects);
    Boolean validateUser(Long id, String password);
    UserDto getUser();
    List<UserDto> getUsers();
    List<UserDto> filterUsersByRole(String role);
    List<String> getDaysList();
    List<LocalTime> getHoursList();
    void deleteById(Long idUser);
}
