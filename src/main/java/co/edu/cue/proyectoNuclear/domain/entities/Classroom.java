package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.Campus;
import co.edu.cue.proyectoNuclear.domain.enums.Property;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name ="classroom")
public class Classroom {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name ="id")
    private Long id;

    @Column (name ="name", nullable=false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column (name ="location", nullable=false)
    private Campus location;

    @Column (name ="status", nullable=false)
    private String status;

    @Column (name ="capacity", nullable=false)
    private Integer capacity;

    @OneToMany(mappedBy = "classroom")
    private List<Subject> subjects;

    @ElementCollection(targetClass = Property.class)
    @CollectionTable(name = "classroom_property", joinColumns = @JoinColumn(name = "classroom_id"))
    @Column(name = "property")
    @Enumerated(EnumType.STRING)
    private List<Property> propertyList;

    @Column (name ="observation", nullable=false)
    private String observation;
}
