package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAOImpl studentDAO;

    private final SubjectDAOImpl subjectDAO;

    @Override
    public Student getStudent() {
        return null;
    }

    @Override
    public List<StudentDto> generateStudent() {
        List<StudentDto> students = studentDAO.getTableList();
        return students;
    }
    @Override
    public void deleteStudentById(Long id) {
        studentDAO.deleteById(id);
    }

    @Override
    public void createStudent(StudentDto student) {
        studentDAO.save(student);
    }

    @Override
    public void editStudent(StudentDto student) {
        studentDAO.update(student);
    }

    public StudentDto findUserStudent(UserDto user) {
        List<StudentDto> studentDtoList = generateStudent();
        StudentDto studentDto = null;
        for (StudentDto student: studentDtoList) {
            if (student.id().equals(user.id())) {
                studentDto = student;
            }
        }
        return studentDto;
    }

    @Override
    public void addSubject(Long subjectId, Long studentId) {

    }
}
