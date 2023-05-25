package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;

import java.util.List;

public interface AdministrativeService {
    //Teacher
    void deleteTeacherById(Long id);
    void editTeacher(UserDto user, TeacherDto teacher);
    void createTeacher(UserDto user, TeacherDto teacher);

    //Student
    void editStudent(UserDto user,StudentDto student);
    void createStudent(UserDto user, StudentDto student);
    void deleteStudentById(Long id);

    //Course
    //Course createCourse(Course course);

    //User
    List<UserDto> getUsers();
}
