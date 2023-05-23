package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.User;

import java.util.List;

public interface StudentService {
    Student getStudent();

    List<Student > generateStudent();
}
