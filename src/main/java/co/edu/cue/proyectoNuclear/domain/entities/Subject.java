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

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String teacherName;

    private Boolean teacherAvailability;
    private Integer hourlyIntensity;
    @OneToMany
    private List<Student> studentList;
}
