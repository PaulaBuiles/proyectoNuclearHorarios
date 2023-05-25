package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.*;

import java.util.List;

public interface AdministrativeService {
    //Teacher
    void deleteTeacherById(Long id);
    void editTeacher(User user, Teacher teacher);
    void createTeacher(User user, Teacher teacher);

    //Student
    void editStudent(User user,Student student);
    void createStudent(User user, Student student);
    void deleteStudentById(Long id);

    //Course
    //Course createCourse(Course course);

    //User
    List<User> getUsers();
}
