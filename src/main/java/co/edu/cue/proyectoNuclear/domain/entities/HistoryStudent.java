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
@Table(name="history_student")
public class HistoryStudent{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name="id_subject")
    private Subject subject;
}
