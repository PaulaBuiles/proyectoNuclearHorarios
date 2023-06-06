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

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "availability_teacher", joinColumns = @JoinColumn(name = "id_teacher",referencedColumnName = "id"))
    private List<Availability> availability;

}
