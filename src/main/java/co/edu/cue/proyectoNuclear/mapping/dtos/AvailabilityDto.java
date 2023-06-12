package co.edu.cue.proyectoNuclear.mapping.dtos;


import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;



import java.time.LocalTime;

public record AvailabilityDto(Long id,
                              DayOfWeek dayOfWeek,
                              LocalTime start,
                              LocalTime end,
                              Teacher teacher) {

}
