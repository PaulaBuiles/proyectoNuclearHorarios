package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    Student getStudent();

    List<StudentDto> generateStudent();
    StudentDto findUserStudent(UserDto user);

    void addSubject(Long subjectId, Long studentId);

    void deleteStudentById(Long id);

    void createStudent(StudentDto student);

    void editStudent(StudentDto student);
}
