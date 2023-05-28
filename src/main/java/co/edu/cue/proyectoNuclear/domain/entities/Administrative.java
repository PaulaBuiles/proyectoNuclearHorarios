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
public class Administrative {

    @Id
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="id_user")
    private User user;

    @Column(name = "charge", nullable = false)
    private String charge;
}
