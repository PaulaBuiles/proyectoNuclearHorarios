package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private final StudentDAOImpl studentDAO;
    @Autowired
    private final SubjectDAOImpl subjectDAO;
    @Autowired
    private final UserDAOImpl userGeneralDAO;
    @Autowired
    private TeacherDAOImpl teacherDAO;
    /*@Autowired
    private final*/

    //Funciones para profesores

    @Override
    public void createTeacher(UserDto user, TeacherDto teacher) {
        userGeneralDAO.save(user);
        teacherDAO.save(teacher);
    }

    @Override
    public void editTeacher(UserDto user, TeacherDto teacher) {
        userGeneralDAO.update(user);
        teacherDAO.update(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        subjectDAO.deleteTeacher(id);
        teacherDAO.deleteById(id);
        userGeneralDAO.delete(id);

    }
}
