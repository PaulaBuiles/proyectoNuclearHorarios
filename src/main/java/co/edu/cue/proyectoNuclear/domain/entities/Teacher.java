package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.Semester;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="teacher")
public class Teacher extends User{

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User user;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Availability availability;
}
