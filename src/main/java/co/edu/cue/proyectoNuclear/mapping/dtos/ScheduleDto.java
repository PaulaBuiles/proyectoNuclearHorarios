package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;

import java.sql.Time;

public record ScheduleDto(Long id,
                          Classroom classroom,
                          Time durability
                          ) {
}
