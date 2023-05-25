package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseDAOImpl implements GeneralDAO<Course>{

    @PersistenceContext
    private EntityManager entityManager;


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
}
