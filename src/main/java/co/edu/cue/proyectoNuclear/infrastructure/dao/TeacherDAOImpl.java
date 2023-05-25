package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TeacherDAOImpl implements GeneralDAO<Teacher> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Teacher> getTableList(){
        String query = "FROM Teacher";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Teacher findById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void save(Teacher entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Teacher entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher != null) {
            entityManager.remove(teacher);
        }
    }
}
