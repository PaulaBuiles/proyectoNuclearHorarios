package co.edu.cue.proyectoNuclear.domain.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "characteristic")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_element", nullable = false)
    private Element element;


    @ManyToOne
    @JoinColumn(name = "id_classroom", nullable = false)
    private Classroom classroom;


    @Column(name = "observation", nullable = false)
    private String observation;
}
