package co.edu.cue.proyectoNuclear.services;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.enums.Campus;
import co.edu.cue.proyectoNuclear.domain.enums.Property;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;

import java.util.List;

public interface ClassroomService {
    List<ClassroomDto> generateClassroom();
    List<Property> createPropertyListFromString(String propertyListString);
    void createClassroom(String number,Integer capacity,Campus location, String status, List<Property> propertyList, String observation);
    Campus determineLocation(String locationValue);
    void editClassroom(Classroom classroomDto);
    void deleteClassroomById(Long id);
    ClassroomDto getClassroomDto();
    ClassroomDto getById(Long id);
}
