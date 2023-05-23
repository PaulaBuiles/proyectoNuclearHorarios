package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="availability")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

}
