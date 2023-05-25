package co.edu.cue.proyectoNuclear.domain.entities;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="history_teacher")
public class HistoryTeacher{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="id_teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="id_subject")
    private Subject subject;
}
