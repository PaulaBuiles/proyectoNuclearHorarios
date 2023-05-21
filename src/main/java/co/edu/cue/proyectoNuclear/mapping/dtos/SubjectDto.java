package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Student;

import java.util.List;

public record SubjectDto(String id,
                         String name,
                         String teacherName,
                         Boolean teacherAvailability,
                         Integer hourlyIntensity,
                         List<Student> studentList) {
}
