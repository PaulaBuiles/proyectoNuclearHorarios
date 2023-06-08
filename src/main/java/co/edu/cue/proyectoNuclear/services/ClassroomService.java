package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;

import java.util.List;

public interface ClassroomService {
    List<ClassroomDto> generateClassroom();
    void createClassroom(Classroom classroomDto);
    void editClassroom(Classroom classroomDto);
    void deleteClassroomById(Long id);
    ClassroomDto getClassroomDto();
}
