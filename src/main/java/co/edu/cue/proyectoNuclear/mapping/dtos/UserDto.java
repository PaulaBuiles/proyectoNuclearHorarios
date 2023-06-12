package co.edu.cue.proyectoNuclear.mapping.dtos;



public record UserDto(Long id,
                      String name,
                      String email,
                      String password,
                      String role,
                      boolean active) {
}
