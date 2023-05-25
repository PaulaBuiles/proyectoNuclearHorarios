package co.edu.cue.proyectoNuclear.mapping.mappers;

import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import org.mapstruct.Mapper;
import co.edu.cue.proyectoNuclear.domain.entities.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto mapTeacher(Teacher source);
    Teacher mapToEntity(TeacherDto source);
    List<TeacherDto> mapList(List<Teacher> source);
}
