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
@Table(name = "history_teacher")
@SecondaryTables({
        @SecondaryTable(name = "teacher"),
        @SecondaryTable(name = "subject")
})
public class HistoryTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Subject subject;

}
