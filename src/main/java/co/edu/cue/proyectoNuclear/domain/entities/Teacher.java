package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.Semester;

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
public class Teacher {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String email;
    @ManyToOne
    private Subject subject;
    private Boolean availability;

    public Teacher(String id, String identification, String name, String email, String password, String role, Subject subject, Boolean availability) {
        super(id, identification, name, email, password, role);
        this.subject = subject;
        this.availability = availability;
    }

    public Teacher() {

    }
}
