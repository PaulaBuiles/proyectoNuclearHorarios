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
@Table(name="subject")
public class Subject{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", nullable=false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_teacher")
    private Teacher teacher;


    @Column(name="credit", nullable=false)
    private int credit;

    @ManyToMany(mappedBy = "cursos",fetch = FetchType.LAZY)
    private List<Student> students;
}
