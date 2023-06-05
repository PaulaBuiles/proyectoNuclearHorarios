package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;

import java.util.List;

public interface TeacherService {
    //Funciones para profesores
    List<TeacherDto> generateTeacher();
    TeacherDto findUserTeacher(UserDto user);

    void createTeacher(UserDto user, TeacherDto teacher);

    void editTeacher(UserDto user, TeacherDto teacher);

    void deleteTeacherById(Long id);

    TeacherDto getById(Long id);
}
