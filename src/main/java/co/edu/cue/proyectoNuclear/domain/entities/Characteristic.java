package co.edu.cue.proyectoNuclear.domain.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "characteristic")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_element")
    private Element element;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_classroom")
    private Classroom classroom;

    @Column(name = "observation", nullable = false)
    private String observation;
}
