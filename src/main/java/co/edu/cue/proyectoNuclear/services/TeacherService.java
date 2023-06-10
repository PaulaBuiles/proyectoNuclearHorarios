package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;

import java.time.LocalTime;
import java.util.List;

public interface TeacherService {
    //Funciones para profesores
    List<TeacherDto> generateTeacher();
    TeacherDto findUserTeacher(UserDto user);

    void createTeacher(String identification,String name,String email,String password,String role);

    void editTeacher(String name, String email);

    void deleteTeacherById(Long id);

    TeacherDto getById(Long id);
    void editAvailability(int day, LocalTime start, LocalTime end, TeacherDto teacherDto);
    void deleteById(Long idTeacher, Long id);
}
