package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.Semester;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @OneToOne
    @JoinColumn(name="id_user")
    private User user;

    @Column(name = "career", nullable = false)
    private String career;

    @Column(name = "semester", nullable = false)
    private int semester;

    @OneToMany(mappedBy="student")
    private List<HistoryStudent> historyStudents;

    @ManyToOne
    @JoinColumn(name="id_course")
    private Course course;
}
