package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.infrastructure.dao.CourseDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.StudentDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.SubjectDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.CourseDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.CourseMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.StudentMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.SubjectMapper;
import co.edu.cue.proyectoNuclear.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAOImpl courseDAO;
    @Autowired
    private final StudentDAOImpl studentDAO;
    @Autowired
    private final SubjectDAOImpl subjectDAO;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private CourseMapper courseMapper;



    public void getCourse(){
        List<CourseDto> courseList = courseDAO.getTableList();
        for (CourseDto courseDto : courseList){
            System.out.println(courseDto.student().getUser().getName()+"--------"+courseDto.subject().getName());
            /*for (Subject subject: courseDto.subject()){
                System.out.println(courseDto.student().getUser().getName()+"--------"+subject.getName());
            }*/
        }
    }

    public void studentToSubject(Long studentId, Long subjectId) {
        StudentDto student = studentDAO.findById(studentId);
        SubjectDto subject = subjectDAO.findById(subjectId);

        if(student != null && subject != null){
            Course course = new Course(29,subjectMapper.mapToEntity(subject), studentMapper.mapToEntity(student));
            courseDAO.save(courseMapper.mapCourse(course));

        }else{
            System.out.println("No funciono");
        }


    }


}
