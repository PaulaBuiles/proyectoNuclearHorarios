package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.infrastructure.dao.SubjectDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.TeacherDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
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


@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAOImpl subjectDAO;

    @Autowired
    private TeacherDAOImpl teacherDAO;

    private SubjectMapper subjectMapper;

    private TeacherMapper teacherMapper;

    private  ClassroomMapper classroomMapper;
    @Autowired
    private  TeacherService teacherService;
    @Autowired
    private  ClassroomService classroomService;

    @Override
    public void addSubject(String name, Long teacherId, int credit, Long classroomId) {
            Classroom classroom = classroomMapper.mapToEntity(classroomService.getById(classroomId));
            Teacher teacher = teacherMapper.mapToEntity(teacherDAO.findById(teacherId));

                SubjectDto subjectDto = new SubjectDto(null, name, null, credit, new ArrayList<>(), classroom, new ArrayList<>());
                Subject subject = subjectMapper.mapToEntity(subjectDto);

                subjectDAO.save(subject);
                addTeacher(teacher,subjectDAO.findByName(name));
    }

    @Override
    public void addTeacher(Teacher teacher, Subject subject){
        subject.setTeacher(teacher);
        subjectDAO.update(subject);
    }

   /* @Override
    public void addSubject(String name, Long teacherId, int credit, Long classroomId) {
        Teacher teacher = teacherMapper.mapToEntity(teacherService.getById(teacherId));
        Classroom classroom = classroomMapper.mapToEntity(classroomService.getById(classroomId));

        System.out.println("Name: " + name);
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Credit: " + credit);
        System.out.println("Classroom ID: " + classroomId);

        System.out.println("Teacher: " + teacher.getName());
        System.out.println("Classroom: " + classroom.getName());

        SubjectDto subject = new SubjectDto(null, name, , credit, new ArrayList<>(), classroom, new ArrayList<>());

        System.out.println("Subject: " + subject);

        subjectDAO.save(subjectMapper.mapToEntity(subject));
    }*/

    public SubjectDto getSubjectByTeacher(String name, TeacherDto teacherDto){
        List<SubjectDto> subjectDtoList = subjectDAO.getTableList();
        SubjectDto subject = null;
        for (SubjectDto subjectDto: subjectDtoList){
            if(subjectDto.name().equals(name) && subjectDto.teacher().getName().equals(teacherDto.name()))
                subject = subjectDto;
            break;
        }
        System.out.println(subject);
        return subject;
    }


}
