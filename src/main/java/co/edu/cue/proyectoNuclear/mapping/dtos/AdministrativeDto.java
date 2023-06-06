package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.User;

public record AdministrativeDto(Long id,
                                String name,
                                String email,
                                String role,
                                String charge
                                ) {
}
