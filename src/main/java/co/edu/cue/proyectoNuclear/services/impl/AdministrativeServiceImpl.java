package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.infrastructure.dao.GeneralDAO;
import co.edu.cue.proyectoNuclear.infrastructure.dao.UserDAOImpl;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AdministrativeServiceImpl implements AdministrativeService {

    private GeneralDAO<Teacher> teacherDAO;

    private GeneralDAO<Student> studentDAO;

    private GeneralDAO<Course> courseDAO;

    @Autowired
    public UserDAOImpl userGeneralDAO;


    @Override
    public void deleteTeacherById(Long id) {
        teacherDAO.delete(id);
    }

    @Override
    public void deleteStudentById(Long id) { studentDAO.delete(id); }

    @Override
    public void createTeacher(User user, Teacher teacher) {
        teacher.setUser(user);
        teacherDAO.save(teacher);
    }

    @Override
    public void createStudent(User user, Student student) {
        //student.setUser(user);
        studentDAO.save(student);
    }

    @Override
    public void editTeacher(User user, Teacher teacher) {
        teacher.setUser(user);
        teacherDAO.update(teacher);
    }

    @Override
    public void editStudent(User user, Student student) {
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
    public List<User> getUsers(){
        List<User> userList = userGeneralDAO.getTableList();
        return userList;
    }

}
