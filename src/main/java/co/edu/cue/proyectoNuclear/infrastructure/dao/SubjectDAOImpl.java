package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SubjectDAOImpl implements GeneralDAO<Subject>{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Subject> getTableList(){
        String query = "FROM Subject";
        List<Subject> subjectList = entityManager.createQuery(query).getResultList();
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Subject findById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    @Override
    public Course save(Subject entity) {

        return null;
    }

    @Override
    public void update(Subject entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        if (subject != null) {
            entityManager.remove(subject);
        }
    }
}
