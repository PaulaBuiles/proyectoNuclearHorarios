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
    EntityManager entityManager;

    @Override
    public List<Course> getTableList(){
        String query = "FROM Course";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void save(Course entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Course entity) {
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
