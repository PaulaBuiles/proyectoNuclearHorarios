package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;



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
    private Long id;

    @Column(name="dayOfWeek", nullable=false)
    private DayOfWeek dayOfWeek;

    @Column(name="start", nullable=false)
    private LocalDate start;

    @Column(name="end", nullable=false)
    private LocalDate end;

    //El profesor tiene cada disponibilidad para él solo
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
