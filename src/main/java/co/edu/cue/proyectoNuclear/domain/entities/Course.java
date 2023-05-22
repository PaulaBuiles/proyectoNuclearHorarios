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
@Table(schema = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Subject subject;
    @OneToMany
    private List<Schedule> scheduleList;
    @OneToMany
    private List<Student> studentList;
}
