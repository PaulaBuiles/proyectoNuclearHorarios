package co.edu.cue.proyectoNuclear.mapping.mappers;


import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.mapping.dtos.AvailabilityDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {
    AvailabilityDto mapAvailability(Availability source);
    Availability mapToEntity(AvailabilityDto source);
    List<AvailabilityDto> mapList(List<Availability> source);
}
