package co.edu.cue.proyectoNuclear.mapping.mappers;

import co.edu.cue.proyectoNuclear.domain.entities.HistoryTeacher;
import co.edu.cue.proyectoNuclear.mapping.dtos.HistoryTeacherDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoryTeacherMapper {
    HistoryTeacherDto mapHistoryTeacher(HistoryTeacher source);
    HistoryTeacher mapToEntity(HistoryTeacherDto source);
    List<HistoryTeacherDto> mapList(List<HistoryTeacher> source);
}
