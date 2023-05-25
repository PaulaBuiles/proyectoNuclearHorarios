package co.edu.cue.proyectoNuclear.mapping.mappers;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {
    ClassroomDto mapClassroom(Classroom source);
    Classroom mapToEntity(ClassroomDto source);
    List<ClassroomDto> mapList(List<Classroom> source);
}
