package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name ="schedule")
public class Schedule {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name ="id")
    private int id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn (name ="id_classroom")
    private Classroom classroom;

    @Column (name ="durability", nullable=false)
    private Time durability;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn (name ="id_subject")
    private Subject subject;
}
