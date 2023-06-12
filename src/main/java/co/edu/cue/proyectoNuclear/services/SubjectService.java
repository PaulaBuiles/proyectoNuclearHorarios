package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;

import java.util.List;

public interface SubjectService {
    void addSubject( String name, Long teacher, int credit,  Long classroom);

    void addTeacher(Teacher teacher, Subject subject);
}
