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

    @ManyToOne
    @JoinColumn(name="id_teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="id_availability")
    private Availability availability;

    @Column(name="credit", nullable=false)
    private int credit;

    @OneToMany(mappedBy="subject")
    private List<HistoryStudent> historyStudents;

    @OneToMany(mappedBy="subject")
    private List<HistoryTeacher> historyTeachers;
}
