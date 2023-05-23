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
@SecondaryTables({
        @SecondaryTable(name = "classroom"),
        @SecondaryTable(name = "element")
})
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_element", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Element element;


    @ManyToOne
    @JoinColumn(name = "id_classroom", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Classroom classroom;


    @Column(name = "observation", nullable = false)
    private String observation;
}
