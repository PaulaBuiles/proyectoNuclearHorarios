package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;

import java.time.LocalTime;

public interface AvailabilityService {
    void newAvailability(int day, LocalTime start, LocalTime end, TeacherDto teacherDto);
    void deleteAvailabilityById(Long id);
    void findAvailabilityById(Long id);
    void editAvailability(int day, LocalTime start, LocalTime end, TeacherDto teacherDto);
}
