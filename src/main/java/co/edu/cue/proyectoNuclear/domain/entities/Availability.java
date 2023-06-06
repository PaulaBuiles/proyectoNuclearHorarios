package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="availability")
public class Availability{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="dayOfWeek", nullable=false)
    private DayOfWeek dayOfWeek;

    @Column(name="start", nullable=false)
    private LocalTime start;

    @Column(name="end", nullable=false)
    private LocalTime end;

    //El profesor tiene cada disponibilidad para él solo
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
