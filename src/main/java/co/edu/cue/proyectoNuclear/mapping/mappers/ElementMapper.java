package co.edu.cue.proyectoNuclear.mapping.mappers;

import co.edu.cue.proyectoNuclear.domain.entities.Element;
import co.edu.cue.proyectoNuclear.mapping.dtos.ElementDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElementMapper {
    ElementDto mapElement(Element source);
    Element mapToEntity(ElementDto source);
    List<ElementDto> mapList(List<Element> source);
}
