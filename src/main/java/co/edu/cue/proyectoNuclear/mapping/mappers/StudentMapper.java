package co.edu.cue.proyectoNuclear.mapping.mappers;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto mapStudent(Student source);
    Student mapToEntity(StudentDto source);
    List<StudentDto> mapList(List<Student> source);
}
