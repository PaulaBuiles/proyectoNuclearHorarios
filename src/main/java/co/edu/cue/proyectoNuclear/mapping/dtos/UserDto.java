package co.edu.cue.proyectoNuclear.mapping.dtos;

import lombok.*;


public record UserDto(String id,
                      String identification,
                      String name,
                      String email,
                      String password,
                      String role) {


}
