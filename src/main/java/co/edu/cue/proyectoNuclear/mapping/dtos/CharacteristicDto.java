package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Element;

public record CharacteristicDto(int id,
                                Element element,
                                Classroom classroom,
                                String observation) {
}
