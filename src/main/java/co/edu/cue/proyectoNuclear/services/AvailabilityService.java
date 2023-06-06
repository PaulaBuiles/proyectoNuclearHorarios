package co.edu.cue.proyectoNuclear.services;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;

import java.sql.Time;
import java.time.LocalTime;

public interface AvailabilityService {
    void newAvailability(DayOfWeek day, LocalTime start, LocalTime end, TeacherDto teacherDto);
}
