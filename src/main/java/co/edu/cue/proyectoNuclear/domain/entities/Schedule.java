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
    private Long id;

    @Column(name="dayOfWeek", nullable=false)
    private DayOfWeek dayOfWeek;

    @Column (name ="durability", nullable=false)
    private Time durability;

    @Column(name="start", nullable=false)
    private LocalTime start;

    @Column(name="end", nullable=false)
    private LocalTime end;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable=false)
    private Subject subject;

}
