package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
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
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Subject findById(String id) {
        return null;
    }

    @Override
    public void save(Subject entity) {

    }

    @Override
    public void update(Subject entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
