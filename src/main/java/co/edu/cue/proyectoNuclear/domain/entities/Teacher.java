package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.Semester;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@Entity
@Table(name ="teachers")
public class Teacher extends User{

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User user;
    @ManyToOne
    private Subject subject;
    private Boolean availability;

    public Teacher(String id, String identification, String name, String email, String password, String role, User user, Subject subject, Boolean availability) {
        super(id, identification, name, email, password, role);
        this.user = user;
        this.subject = subject;
        this.availability = availability;
    }

    public Teacher() {

    }
}
