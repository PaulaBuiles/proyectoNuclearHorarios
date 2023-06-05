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
//@PrimaryKeyJoinColumn(referencedColumnName = "id_user")
public class Student extends User{
    @Column(name = "career", nullable = false)
    private String career;

    @Column(name = "semester", nullable = false)
    private Semester semester;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "course", joinColumns = @JoinColumn(name = "id_student",referencedColumnName = "id"))
    private List<Subject> cursos;

}
