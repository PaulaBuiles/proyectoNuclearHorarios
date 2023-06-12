package co.edu.cue.proyectoNuclear.mapping.dtos;



public record AdministrativeDto(Long id,
                                String name,
                                String email,
                                String password,
                                String role,
                                Boolean active,
                                String charge
                                ) {
}
