package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.User;

public record TeacherDto(Long id,
                         Availability availability,
                         User user) {
}
