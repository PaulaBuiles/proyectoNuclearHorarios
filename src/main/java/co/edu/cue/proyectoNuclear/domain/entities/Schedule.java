package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "schedule")
@SecondaryTables({
        @SecondaryTable(name = "classroom"),
        @SecondaryTable(name = "availability"),
        @SecondaryTable(name = "course")
})
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_availability", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Availability availability;

    @ManyToOne
    @JoinColumn(name = "id_classroom", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Classroom classroom;

    @Column(name = "duration", nullable = false)
    private LocalTime duration;

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Course course;

}
