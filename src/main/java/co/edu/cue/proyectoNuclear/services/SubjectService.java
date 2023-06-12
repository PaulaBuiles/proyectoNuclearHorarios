package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;

import java.util.List;

public interface SubjectService {
    void addSubject( String name, Long teacher, int credit,  Long classroom);
    void addTeacher(Teacher teacher, Subject subject);
    void deleteById(Long idSubject);
    void updateSubject(Long subjectId,  Long newTeacherId, int newCredit, Long newClassroomId);
    SubjectDto getSubjectByTeacher(String name, TeacherDto teacherDto);
}
