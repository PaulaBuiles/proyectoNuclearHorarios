package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;

import java.sql.Time;

public record ScheduleDto(int id,
                          Classroom classroom,
                          Time durability,
                          Subject subject
                          ) {
}
