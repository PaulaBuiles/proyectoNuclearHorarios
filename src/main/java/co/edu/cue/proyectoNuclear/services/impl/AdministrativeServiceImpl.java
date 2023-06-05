package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdministrativeServiceImpl implements AdministrativeService {

    @Autowired
    private TeacherDAOImpl teacherDAO;
    @Autowired
    private SubjectDAOImpl subjectDAO;

    @Autowired
    private StudentDAOImpl studentDAO;

    @Autowired
    private ScheduleDAOImpl scheduleDAO;

    @Autowired
    public UserDAOImpl userGeneralDAO;

    private TeacherService teacherService;

    private StudentService studentService;

    private UserService userService;

    @Autowired
    public AdministrativeServiceImpl(TeacherService teacherService,
                                     StudentService studentService,
                                     UserService userService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.userService = userService;
    }



    //Funciones de los horarios

    //Funciones de los cursos



    //Funciones de los elementos

    //Funciones de la disponibilidad

    //Funciones de las caracteristicas


}
