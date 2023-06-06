package co.edu.cue.proyectoNuclear.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name ="classroom")
public class Classroom {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name ="id")
    private int id;

    @Column (name ="number", nullable=false)
    private String number;

    @Column (name ="location", nullable=false)
    private String location;

    @Column (name ="capacity", nullable=false)
    private String capacity;
}
