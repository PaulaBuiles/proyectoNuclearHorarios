package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.Campus;
import co.edu.cue.proyectoNuclear.domain.enums.Element;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String number;
    private Integer capacity;
    private Campus campus;
    @OneToMany
    private List<Property> propertyList;
    @OneToOne
    private Subject subject;
}
