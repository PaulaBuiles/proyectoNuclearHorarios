package co.edu.cue.proyectoNuclear.domain.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity

public class Administrative {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String email;
}
