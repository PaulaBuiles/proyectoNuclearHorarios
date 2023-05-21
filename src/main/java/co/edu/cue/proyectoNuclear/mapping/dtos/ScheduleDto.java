package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;

public record ScheduleDto(String id,
                          DayOfWeek dayOfWeek,
                          Classroom classroom) {
}
