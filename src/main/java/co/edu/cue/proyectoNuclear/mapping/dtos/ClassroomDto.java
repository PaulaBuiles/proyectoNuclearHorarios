package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;

import java.util.List;

public record ClassroomDto(String id,
                           String number,
                           Integer capacity,
                           String location,
                           List<Availability> availability) {
}
