package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Student;

public record CourseDto(int id,
                        String name,
                        Student student) {
}
