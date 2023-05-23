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
@Table(name ="students")
public class Student extends User{

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User user;
    private Semester semester;
    @OneToMany
    private List<Subject> subjectList;
}
