package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.enums.Propertie;

import java.util.List;

public record ClassroomDto(String id,
                           String number,
                           Integer capacity,
                           List<Propertie> propertieList,
                           List<Subject> subjectList) {
}
