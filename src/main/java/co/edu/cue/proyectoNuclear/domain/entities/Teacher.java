package co.edu.cue.proyectoNuclear.domain.entities;



import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="teacher")
//@PrimaryKeyJoinColumn(referencedColumnName = "user_id")
public class Teacher extends User{

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Subject> subjects;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "teacher")
    private List<Availability> availability;

}
