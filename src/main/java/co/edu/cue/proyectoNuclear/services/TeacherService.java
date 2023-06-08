package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;

import java.util.List;

public interface TeacherService {
    //Funciones para profesores
    List<TeacherDto> generateTeacher();
    TeacherDto findUserTeacher(UserDto user);

    void createTeacher(Long identification,String name,String email,String password,String role);

    void editTeacher(String name, String email);

    void deleteTeacherById(Long id);

    TeacherDto getById(Long id);
}
