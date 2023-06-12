package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;

import java.sql.Time;
import java.time.LocalTime;

public interface ScheduleService {
     void asingSubject(Long id, DayOfWeek dayOfWeek, Time durability, LocalTime start, LocalTime end, Subject subject);
     Boolean verifyAvailability(DayOfWeek dayOfWeek, LocalTime start, LocalTime end, String classroom);
}
