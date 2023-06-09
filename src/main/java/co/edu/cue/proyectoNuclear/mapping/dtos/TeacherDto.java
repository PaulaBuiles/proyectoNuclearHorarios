package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;


import java.util.List;

public record TeacherDto(Long id,
                         String name,
                         String email,
                         String password,
                         String role,
                         boolean active,
                         List<Availability> availability,
                         List<Subject> subjects) {
}
