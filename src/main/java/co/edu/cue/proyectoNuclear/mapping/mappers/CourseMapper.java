package co.edu.cue.proyectoNuclear.mapping.mappers;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.mapping.dtos.CourseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto mapCourse(Course source);
    Course mapToEntity(CourseDto source);
    List<CourseDto> mapList(List<Course> source);

}
