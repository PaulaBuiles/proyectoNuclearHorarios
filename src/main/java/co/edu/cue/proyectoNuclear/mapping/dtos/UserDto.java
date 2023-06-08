package co.edu.cue.proyectoNuclear.mapping.dtos;

import co.edu.cue.proyectoNuclear.domain.entities.User;
import lombok.*;


public record UserDto(Long id,
                      String name,
                      String email,
                      String password,
                      String role,
                      boolean active) {
}
