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



    //Funciones de los horarios

    //Funciones de los cursos

    //Funciones de los elementos

    //Funciones de la disponibilidad

    //Funciones de las caracteristicas


}
