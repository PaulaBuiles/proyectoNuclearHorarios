package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.enums.Campus;
import co.edu.cue.proyectoNuclear.domain.enums.Property;

import java.util.List;

public record ClassroomDto(Long id,
                           String name,
                           Integer capacity,
                           Campus location,
                           String status,
                           List<Subject> subjects,
                           List<Property> propertyList,
                           String observation) {
}
