package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
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

    @Override
    public void createAdministrative(Long identification,String name,String email,String password,String role,String charge){
        AdministrativeDto administrativeDto = new AdministrativeDto(identification,name,email,password,role,true,charge);

    }



    //Funciones de los horarios

    //Funciones de los cursos



    //Funciones de los elementos

    //Funciones de la disponibilidad

    //Funciones de las caracteristicas


}
