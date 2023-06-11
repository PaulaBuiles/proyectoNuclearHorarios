package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Schedule;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;

import java.util.List;

public interface SubjectService {
    void addSubject(String name, Teacher teacher, int credit, List<Student> students, Classroom classroom, List<Schedule> schedule);
}
