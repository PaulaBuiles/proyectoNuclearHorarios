package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;

public record TeacherDto(String name,
                         String id,
                         String email,
                         Subject subject,
                         Boolean availability) {
}
