package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.HistoryStudent;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.enums.Semester;

import java.util.List;

public record StudentDto(User user,
                         String id,
                         String career,
                         Semester semester,
                         List<HistoryStudent> historyStudents,
                         Course course
                         ) {
}
