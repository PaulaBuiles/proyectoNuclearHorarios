package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;

import java.sql.Time;
import java.time.LocalTime;

public record ScheduleDto(Long id,
                          DayOfWeek dayOfWeek,
                          Time durability,
                          LocalTime start,
                          LocalTime end,
                          Subject subject
                          ) {
}
