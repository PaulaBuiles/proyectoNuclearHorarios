package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.enums.Semester;

import java.util.List;

public record StudentDto(Long id,
                         String name,
                         String email,
                         String password,
                         String role,
                         boolean active,
                         String career,
                         Semester semester,
                         List<Subject> subject
                         ) {
}
