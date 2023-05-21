package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.enums.Semester;

import java.util.List;

public record StudentDto(String name,
                         String id,
                         String email,
                         Semester semester,
                         List<Subject> subjectList) {
}
