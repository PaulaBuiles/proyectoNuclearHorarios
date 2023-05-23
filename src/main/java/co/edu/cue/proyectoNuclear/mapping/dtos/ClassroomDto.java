package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Property;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.enums.Element;

import java.util.List;

public record ClassroomDto(String id,
                           String number,
                           Integer capacity,
                           List<Property> propertieList,
                           List<Subject> subjectList) {
}
