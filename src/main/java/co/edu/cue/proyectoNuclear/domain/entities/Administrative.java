package co.edu.cue.proyectoNuclear.domain.entities;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "administrative")
public class Administrative extends User{

    @Column(name = "charge", nullable = false)
    private String charge;
}
