package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;

import java.sql.Time;

public record ScheduleDto(int id,
                          Classroom classroom,
                          Time durability,
                          Subject subject
                          ) {
}
