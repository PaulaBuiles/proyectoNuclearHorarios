package co.edu.cue.proyectoNuclear.mapping.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record UserLoginDto(Long identification,
                           String password) {
    public UserLoginDto() {
        this(null, null);
    }
}
