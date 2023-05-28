package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Element;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;

import java.util.List;

public record ClassroomDto(String id,
                           String number,
                           Integer capacity,
                           String location,
                           Availability availability) {
}
