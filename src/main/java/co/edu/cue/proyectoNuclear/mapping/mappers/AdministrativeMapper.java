package co.edu.cue.proyectoNuclear.mapping.mappers;

import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministrativeMapper {
    AdministrativeDto mapAdministrative(Administrative source);
    Administrative mapToEntity(AdministrativeDto source);
    List<AdministrativeDto> maplist(List<Administrative> source);
}
