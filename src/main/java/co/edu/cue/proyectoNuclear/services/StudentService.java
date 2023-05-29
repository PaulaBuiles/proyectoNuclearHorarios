package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    Boolean addSubject();
    Student getStudent();

    List<Student > generateStudent();
}
