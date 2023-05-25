package co.edu.cue.proyectoNuclear.mapping.mappers;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoryStudentMapper {
    HistoryStudentDto mapHistoryStudent(HistoryStudent source);
    HistoryStudent mapToEntity(HistoryStudentDto source);
    List<HistoryStudentDto> mapList(List<HistoryStudent> source);
}
