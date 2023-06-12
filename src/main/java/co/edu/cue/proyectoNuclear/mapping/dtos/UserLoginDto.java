package co.edu.cue.proyectoNuclear.mapping.dtos;



public record UserLoginDto(Long identification,
                           String password) {
    public UserLoginDto() {
        this(null, null);
    }
}
