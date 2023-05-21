package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private DayOfWeek dayOfWeek;
    @ManyToOne
    private Classroom classroom;
}
