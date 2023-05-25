package co.edu.cue.proyectoNuclear.mapping.mappers;

import java.util.List;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectDto mapSubject(Subject source);
    Subject mapToEntity(SubjectDto source);
    List<SubjectDto> mapList(List<Subject> source);
}
