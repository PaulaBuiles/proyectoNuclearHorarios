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
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn (name ="id_subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name="id_student")
    private Student student;
}
