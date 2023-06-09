package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface StudentService {

    Student getStudent();

    List<StudentDto> generateStudent();
    StudentDto findUserStudent(UserDto user);

    void deleteStudentById(Long id);

    void createStudent(String identification,String name,String email,String password,String role,String career,int semester);

    void editStudent(String name, String email);
    void deleteSubject(Student student, Long idSubject);
}
