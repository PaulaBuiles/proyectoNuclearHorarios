package co.edu.cue.proyectoNuclear.domain.entities;

import              co.edu.cue.proyectoNuclear.domain.enums.Campus;
import co.edu.cue.proyectoNuclear.domain.enums.Propertie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String number;
    private Integer capacity;
    private Campus campus;
    @OneToMany
    private List<Propertie> propertieList;
    @OneToOne
    private Subject subject;
}
