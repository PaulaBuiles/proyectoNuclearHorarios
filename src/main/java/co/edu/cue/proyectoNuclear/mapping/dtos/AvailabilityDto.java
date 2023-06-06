package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Schedule;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import org.springframework.cglib.core.Local;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public record AvailabilityDto(Long id,
                              DayOfWeek dayOfWeek,
                              LocalDate start,
                              LocalDate end,
                              Teacher teacher) {

}
