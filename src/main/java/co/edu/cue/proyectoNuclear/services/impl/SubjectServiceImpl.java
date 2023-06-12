package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.infrastructure.dao.SubjectDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.TeacherDAOImpl;
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


@Service // Anotación de Spring para marcar esta clase como un componente de servicio
@AllArgsConstructor // Anotación de Lombok para generar automáticamente un constructor que acepta todos los campos
public class SubjectServiceImpl implements SubjectService {

    @Autowired // Inyección de dependencias de SubjectDAOImpl
    private SubjectDAOImpl subjectDAO;

    @Autowired // Inyección de dependencias de TeacherDAOImpl
    private TeacherDAOImpl teacherDAO;

    @Autowired // Inyección de dependencias de SubjectMapper
    private SubjectMapper subjectMapper;

    @Autowired // Inyección de dependencias de TeacherMapper
    private TeacherMapper teacherMapper;

    @Autowired // Inyección de dependencias de ClassroomMapper
    private ClassroomMapper classroomMapper;

    @Autowired // Inyección de dependencias de TeacherService
    private TeacherService teacherService;

    @Autowired // Inyección de dependencias de ClassroomService
    private ClassroomService classroomService;

    @Override
    public void addSubject(String name, Long teacherId, int credit, Long classroomId) {
        Classroom classroom = classroomMapper.mapToEntity(classroomService.getById(classroomId));
        Teacher teacher = teacherMapper.mapToEntity(teacherDAO.findById(teacherId));

        // Crear un nuevo objeto SubjectDto
        SubjectDto subjectDto = new SubjectDto(null, name, null, credit, new ArrayList<>(), classroom, new ArrayList<>());
        Subject subject = subjectMapper.mapToEntity(subjectDto);

        // Guardar el objeto Subject en la base de datos
        subjectDAO.save(subject);

        // Asignar el profesor al objeto Subject
        addTeacher(teacher, subjectDAO.findByName(name));
    }

    @Override
    public void addTeacher(Teacher teacher, Subject subject) {
        subject.setTeacher(teacher);
        subjectDAO.update(subject);
    }

    @Override
    public void deleteById(Long idSubject) {
        subjectDAO.delete(idSubject); // Eliminar una asignatura por su ID
    }

    @Override
    public void updateSubject(Long subjectId, Long newTeacherId, int newCredit, Long newClassroomId) {
        SubjectDto subjectDto = subjectDAO.findById(subjectId);
        Subject subject = subjectMapper.mapToEntity(subjectDto);
        if (subject != null) {
            // Actualizar los campos de la asignatura
            subject.setCredit(newCredit);
            Classroom newClassroom = classroomMapper.mapToEntity(classroomService.getById(newClassroomId));
            subject.setClassroom(newClassroom);

            Teacher newTeacher = teacherMapper.mapToEntity(teacherDAO.findById(newTeacherId));
            subject.setTeacher(newTeacher);

            // Actualizar la asignatura en la base de datos
            subjectDAO.update(subject);
        }
    }

    public SubjectDto getSubjectByTeacher(String name, TeacherDto teacherDto) {
        // Obtener la lista de asignaturas
        List<SubjectDto> subjectDtoList = subjectDAO.getTableList();
        SubjectDto subject = null;
        // Buscar la asignatura por el nombre y el profesor
        for (SubjectDto subjectDto : subjectDtoList) {
            if (subjectDto.name().equals(name) && subjectDto.teacher().getName().equals(teacherDto.name())) {
                subject = subjectDto;
                break;
            }
        }
        return subject;
    }
}
