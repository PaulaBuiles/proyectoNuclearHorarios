package co.edu.cue.proyectoNuclear.infrastructure.dao;

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
    public Course findById(String id) {
        return null;
    }

    @Override
    public void save(Course entity) {

    }

    @Override
    public void update(Course entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
