package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.enums.Semester;

public record StudentDto(Long id,
                         User user,
                         String career,
                         Semester semester
                         ) {
}
