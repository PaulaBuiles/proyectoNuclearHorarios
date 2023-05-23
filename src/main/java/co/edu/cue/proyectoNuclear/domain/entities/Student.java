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
@Data
@Table(name ="student")
public class Student extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "career", nullable = false)
    private String career;

    @Column(name = "semester", nullable = false)
    private int semester;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}
