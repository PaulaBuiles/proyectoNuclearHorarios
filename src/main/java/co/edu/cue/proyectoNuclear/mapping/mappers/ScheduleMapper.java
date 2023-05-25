package co.edu.cue.proyectoNuclear.mapping.mappers;

import org.mapstruct.Mapper;
import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleDto mapSchedule(Schedule source);
    Schedule mapToEntity(ScheduleDto source);
    List<ScheduleDto> mapList(List<Schedule> source);
}
