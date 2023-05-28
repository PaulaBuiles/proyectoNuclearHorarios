package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.mapping.dtos.CourseDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.CourseMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseDAOImpl implements GeneralDAO<CourseDto>{

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseDto> getTableList() {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> courseList = query.getResultList();
        return courseMapper.mapList(courseList);
    }

    @Override
    public CourseDto findById(Long id) {
        Course course = entityManager.find(Course.class, id);
        return courseMapper.mapCourse(course);
    }

    @Override
    public void save(CourseDto entity) {
        Course course = courseMapper.mapToEntity(entity);
        entityManager.persist(course);
    }

    @Override
    public void update(CourseDto entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Course course = entityManager.find(Course.class, id);
        if (course != null) {
            entityManager.remove(course);
        }
    }

    public void deleteCourseStudent(Long id) {
        List<CourseDto> courses = getTableList();
        for (CourseDto course : courses) {
            if(course.student().getUser().getId().equals(id)) {
                System.out.println(course.student().getUser().getName()+" "+course.id());
                delete((long) course.id());
            }
        }
    }
}
