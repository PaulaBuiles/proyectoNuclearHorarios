package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    Student getStudent();

    List<Student > generateStudent();
}
