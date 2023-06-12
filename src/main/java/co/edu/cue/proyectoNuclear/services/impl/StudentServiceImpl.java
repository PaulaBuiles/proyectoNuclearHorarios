package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.enums.Semester;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.ScheduleDto;
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
@AllArgsConstructor // Anotación de Lombok para generar automáticamente un constructor que acepta todos los campos
@Service // Anotación de Spring para marcar esta clase como un componente de servicio
public class StudentServiceImpl implements StudentService {

    @Autowired // Inyección de dependencias de UserService
    private final UserService userService;

    @Autowired // Inyección de dependencias de StudentDAOImpl
    private StudentDAOImpl studentDAO;

    @Autowired // Inyección de dependencias de StudentMapper
    private StudentMapper studentMapper;


    @Override
    public Student getStudent() {
        return null; // Devuelve null, no se implementa la funcionalidad
    }

    @Override
    public List<StudentDto> generateStudent() {
        // Obtener la lista de estudiantes existentes
        List<StudentDto> students = studentDAO.getTableList();
        return students;
    }

    @Override
    public void deleteStudentById(Long id) {
        studentDAO.deleteById(id); // Eliminar un estudiante por su ID
    }

    @Override
    public void createStudent(String identification, String name, String email, String password, String role, String career, int semester) {
        Long id = Long.parseLong(identification);
        Semester[] semesters = Semester.values();
        if (semester > 0 && semester < semesters.length) {
            Semester selectedSemester = semesters[semester];
            // Crear un nuevo estudiante
            StudentDto studentDto = new StudentDto(id, name, email, password, role, true, career, selectedSemester, new ArrayList<>());
            studentDAO.save(studentMapper.mapToEntity(studentDto));
        } else {
            throw new IllegalArgumentException("Semestre inválido: " + semester);
        }
    }

    @Override
    public void editStudent(String name, String email) {
        // Obtener el estudiante actual del usuario
        Student user = studentMapper.mapToEntity(findUserStudent(userService.getUser()));
        // Actualizar el nombre y el correo electrónico del estudiante
        user.setName(name);
        user.setEmail(email);
        studentDAO.update(user);
    }

    public StudentDto findUserStudent(UserDto user) {
        // Obtener la lista de estudiantes
        List<StudentDto> studentDtoList = generateStudent();
        StudentDto studentDto = null;
        // Buscar al estudiante por el ID del usuario
        for (StudentDto student : studentDtoList) {
            if (student.id().equals(user.id())) {
                studentDto = student;
            }
        }
        return studentDto;
    }
}