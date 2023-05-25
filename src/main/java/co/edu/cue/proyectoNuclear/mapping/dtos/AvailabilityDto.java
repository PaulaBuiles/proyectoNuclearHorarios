package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Schedule;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;

import java.sql.Time;
import java.util.List;

public record AvailabilityDto(int id,
                              String dayOfWeek,
                              Time start,
                              Time end,
                              List<Teacher> teachers,
                              List<Subject> subjects,
                              List<Schedule> schedules,
                              List<Classroom> classrooms) {

}
