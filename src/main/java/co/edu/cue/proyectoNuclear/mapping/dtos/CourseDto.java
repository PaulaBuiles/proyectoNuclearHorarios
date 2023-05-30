package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;

import java.util.List;

public record CourseDto(int id,
                        Subject subject,
                        Student student) {
}
