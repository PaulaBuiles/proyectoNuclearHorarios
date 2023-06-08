package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.enums.Semester;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.StudentMapper;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private final UserService userService;

    @Autowired
    private StudentDAOImpl studentDAO;

    @Autowired
    private StudentMapper studentMapper;

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
    public void createStudent(Long identification, String name, String email, String password, String role, String career, int semester) {
        Semester[] semesters = Semester.values();
        if (semester > 0 && semester < semesters.length) {
            Semester selectedSemester = semesters[semester];
            StudentDto studentDto = new StudentDto(identification,name,email,password,role,true,career,selectedSemester,new ArrayList<>());
            studentDAO.save(studentMapper.mapToEntity(studentDto));
        } else {
            throw new IllegalArgumentException("Semestre invalido: " + semester);
        }
    }

    @Override
    public void editStudent(String name, String email) {
        Student user = studentMapper.mapToEntity(findUserStudent(userService.getUser()));
        user.setName(name);
        user.setEmail(email);
        studentDAO.update(user);
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

}
