package co.edu.cue.proyectoNuclear.domain.entities;


import co.edu.cue.proyectoNuclear.domain.enums.Element;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="element")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Element element;
}
