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
@Table(name = "subject")
@SecondaryTables({
        @SecondaryTable(name = "teacher"),
        @SecondaryTable(name = "availability"),
})
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_availability", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Availability availability;

    @Column(name = "credit", nullable = false)
    private int credit;


}
