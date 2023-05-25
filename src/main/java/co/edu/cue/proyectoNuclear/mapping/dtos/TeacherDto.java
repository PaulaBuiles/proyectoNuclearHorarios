package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.HistoryTeacher;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.User;

import java.util.List;

public record TeacherDto(Availability availability,
                         User user,
                         List<HistoryTeacher> historyTeachers,
                         List<Subject> subjects) {
}
