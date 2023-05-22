package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements GeneralDAO<Student>{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Student> getTableList() {
        String query = "FROM Student";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public void save(Student entity) {

    }

    @Override
    public void update(Student entity) {

    }

    @Override
    public void delete(Student entity) {

    }
}
