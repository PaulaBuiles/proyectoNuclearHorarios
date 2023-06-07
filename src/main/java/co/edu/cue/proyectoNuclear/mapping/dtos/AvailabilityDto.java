package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Schedule;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import org.springframework.cglib.core.Local;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record AvailabilityDto(Long id,
                              DayOfWeek dayOfWeek,
                              LocalTime start,
                              LocalTime end,
                              Teacher teacher) {

}
