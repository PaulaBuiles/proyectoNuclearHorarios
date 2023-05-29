package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;

public interface TeacherService {
    //Funciones para profesores

    void createTeacher(UserDto user, TeacherDto teacher);

    void editTeacher(UserDto user, TeacherDto teacher);

    void deleteTeacherById(Long id);
}
