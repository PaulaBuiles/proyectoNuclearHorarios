package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.Semester;

import java.util.List;

import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="teacher")
    //@PrimaryKeyJoinColumn(referencedColumnName = "id_user")
public class Teacher extends User{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_availability")
    private List<Availability> availability;

}
