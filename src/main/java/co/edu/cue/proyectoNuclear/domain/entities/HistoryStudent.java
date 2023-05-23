package co.edu.cue.proyectoNuclear.domain.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "history_student")
@SecondaryTables({
        @SecondaryTable(name = "student"),
        @SecondaryTable(name = "subject")
})
public class HistoryStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Subject subject;

}
