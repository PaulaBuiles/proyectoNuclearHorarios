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
@Entity
@Table(name="availability")
public class Availability{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="dayOfWeek", nullable=false)
    private String dayOfWeek;

    @Column(name="start", nullable=false)
    private Time start;

    @Column(name="end", nullable=false)
    private Time end;


}
