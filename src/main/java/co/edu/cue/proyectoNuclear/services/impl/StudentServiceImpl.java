package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Student> students = new ArrayList<Student>();
        return null;
    }

    @Override
    public Boolean addSubject(){

        return null;
    }
}
