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
    private HistoryTeacherDAOImpl historyTeacherDAO;
    @Autowired
    private HistoryStudentDAOImpl historyStudentDAO;
    @Autowired
    private SubjectDAOImpl subjectDAO;

    @Autowired
    private StudentDAOImpl studentDAO;

    @Autowired
    private ScheduleDAOImpl scheduleDAO;


    @Autowired
    private CourseDAOImpl courseDAO;

    @Autowired
    public UserDAOImpl userGeneralDAO;


    @Override
    public void deleteTeacherById(Long id) {
        historyTeacherDAO.deleteTeacher(id);
        subjectDAO.deleteTeacher(id);
        teacherDAO.deleteById(id);
        userGeneralDAO.delete(id);

    }

    @Override
    public void deleteStudentById(Long id) {
        System.out.println(1);
        historyStudentDAO.deleteStudent(id);
        System.out.println(2);
        courseDAO.deleteCourseStudent(id);
        System.out.println(3);
        studentDAO.deleteById(id);
        System.out.println(4);
        userGeneralDAO.delete(id);
        System.out.println(5);
    }


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
