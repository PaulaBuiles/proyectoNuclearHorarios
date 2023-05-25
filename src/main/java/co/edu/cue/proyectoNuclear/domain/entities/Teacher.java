package co.edu.cue.proyectoNuclear.domain.entities;

import co.edu.cue.proyectoNuclear.domain.enums.Semester;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="teacher")
public class Teacher{

    @ManyToOne
    @JoinColumn(name="id_availability")
    private Availability availability;

    @Id
    @OneToOne
    @JoinColumn(name="id_user")
    private User user;

    @OneToMany(mappedBy="teacher")
    private List<HistoryTeacher> historyTeachers;

    @OneToMany(mappedBy="teacher")
    private List<Subject> subjects;
}
