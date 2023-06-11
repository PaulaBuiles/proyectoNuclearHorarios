package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.infrastructure.dao.SubjectDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.TeacherDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.ClassroomMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.SubjectMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import co.edu.cue.proyectoNuclear.services.ClassroomService;
import co.edu.cue.proyectoNuclear.services.SubjectService;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAOImpl subjectDAO;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private TeacherDAOImpl teacherDAO;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private  ClassroomMapper classroomMapper;
    @Autowired
    private  TeacherService teacherService;
    @Autowired
    private  ClassroomService classroomService;


    @Override
    public void addSubject(String name, Long teacherId, int credit, Long classroomId) {
        Teacher teacher = teacherMapper.mapToEntity(teacherService.getById(teacherId));
        Classroom classroom = classroomMapper.mapToEntity(classroomService.getById(classroomId));
        SubjectDto subject = new SubjectDto(null, name, teacher, credit, new ArrayList<>(), classroom, new ArrayList<>());
        subjectDAO.save(subjectMapper.mapToEntity(subject));
    }


}
