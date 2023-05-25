package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.CourseDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AdministrativeServiceImpl implements AdministrativeService {

    @Autowired
    private TeacherDAOImpl teacherDAO;

    @Autowired
    private StudentDAOImpl studentDAO;


    @Autowired
    private CourseDAOImpl courseDAO;

    @Autowired
    public UserDAOImpl userGeneralDAO;


    @Override
    public void deleteTeacherById(Long id) {
        teacherDAO.delete(id);
    }

    @Override
    public void deleteStudentById(Long id) { studentDAO.delete(id); }


    @Override
    public void createStudent(UserDto user, StudentDto student) {
        //student.setUser(user);
        studentDAO.save(student);
    }

    @Override
    public void editTeacher(UserDto user, TeacherDto teacher) {
        teacherDAO.update(teacher);
    }

    @Override
    public void createTeacher(UserDto user, TeacherDto teacher) {

    }

    @Override
    public void editStudent(UserDto user, StudentDto student) {
        studentDAO.update(student);
    }

    //Courses
    /*@Override
    public Course createCourse(Course course) {
        return
                courseDAO.save(course);
    }*/

    //User
    @Override
    public List<UserDto> getUsers(){
        return userGeneralDAO.getTableList();
    }

}
