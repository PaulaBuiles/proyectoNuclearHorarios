package co.edu.cue.proyectoNuclear.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToOne(mappedBy = "user")
    private Administrative administrative;

    @OneToOne(mappedBy = "user")
    private Student student;

    @OneToOne(mappedBy = "user")
    private Teacher teacher;
}
