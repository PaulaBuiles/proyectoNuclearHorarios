package co.edu.cue.proyectoNuclear.mapping.mappers;

import co.edu.cue.proyectoNuclear.domain.entities.Characteristic;
import co.edu.cue.proyectoNuclear.mapping.dtos.CharacteristicDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacteristicMapper {
    CharacteristicDto mapCharacteristic(Characteristic source);
    Characteristic mapToEntity(CharacteristicDto source);
    List<CharacteristicDto> mapList(List<Characteristic> source);
}
