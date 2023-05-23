package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.enums.Semester;
import co.edu.cue.proyectoNuclear.infrastructure.dao.GeneralDAO;
import co.edu.cue.proyectoNuclear.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public Student getStudent() {
        return null;
    }

    @Override
    public List<Student> generateStudent() {
        return null;
    }
}
