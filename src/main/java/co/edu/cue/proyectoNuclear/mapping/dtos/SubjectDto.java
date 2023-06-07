package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.*;

import java.util.List;

public record SubjectDto(String id,
                         String name,
                         Teacher teacher,
                         int credit,
                         List<Student> students,
                         Classroom classroom,
                         List<Schedule> schedules
                         ) {
}
