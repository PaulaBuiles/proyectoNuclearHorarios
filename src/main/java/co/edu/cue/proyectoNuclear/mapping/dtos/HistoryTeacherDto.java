package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;

public record HistoryTeacherDto (int id,
                                 Teacher teacher,
                                 Subject subject){
}