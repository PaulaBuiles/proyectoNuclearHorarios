package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.HistoryStudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.StudentMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.SubjectMapper;
import co.edu.cue.proyectoNuclear.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentDAOImpl studentDAO;
    @Autowired
    private final SubjectDAOImpl subjectDAO;
    @Autowired
    private final HistoryStudentDAOImpl historyStudentDAO;
    @Autowired
    private final CourseDAOImpl courseDAO;
    @Autowired
    private final UserDAOImpl userGeneralDAO;

    private StudentMapper studentMapper;

    private SubjectMapper subjectMapper;
    /*@Autowired
    private List<Student> studentList= new ArrayList<>();*/

    @Override
    public Student getStudent() {
        return null;
    }

    @Override
    public List<Student> generateStudent() {
        List<Student> students = new ArrayList<Student>();
        return students;
    }

    //Asignar materia a un estudiante
    @Override
    public void addSubject(Long subjectId, Long studentId){
        // Obtener las instancias de Subject y Student correspondientes a los IDs
        SubjectDto subjectDto = subjectDAO.findById(subjectId);
        StudentDto studentDto = studentDAO.findById(studentId);

        // Crear una nueva instancia de NombreEntidad y establecer los valores
        HistoryStudentDto historyStudentDto = new HistoryStudentDto(null,
                studentMapper.mapToEntity(studentDto),
                subjectMapper.mapToEntity(subjectDto));

        //System.out.println(historyStudentDto.student().getUser().getName());
        //System.out.println(historyStudentDto.subject().getName());
        // Guardar la nueva fila en la tabla
        //historyStudentDAO.save(historyStudentDto);

    }

    public void studentToSubject(Long studentId, Long subjectId) {
        StudentDto student = studentDAO.findById(studentId);
        SubjectDto subject = subjectDAO.findById(subjectId);

        /*if (student != null && subject != null) {

        } else {
            // Manejar el caso cuando no se encuentra el estudiante o la materia
        }*/
    }

    @Override
    public void deleteStudentById(Long id) {
        historyStudentDAO.deleteStudent(id);
        courseDAO.deleteCourseStudent(id);
        studentDAO.deleteById(id);
        userGeneralDAO.delete(id);
    }

    @Override
    public void createStudent(UserDto user, StudentDto student) {
        userGeneralDAO.save(user);
        studentDAO.save(student);
    }

    @Override
    public void editStudent(UserDto user, StudentDto student) {
        userGeneralDAO.update(user);
        studentDAO.update(student);
    }
}
