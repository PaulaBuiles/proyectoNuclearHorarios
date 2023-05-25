package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

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
    public Student findById(Long id) {return entityManager.find(Student.class,id);}

    @Override
    public void save(Student entity) {
        entityManager.persist(entity);

    }

    @Override
    public void update(Student entity) {
        entityManager.merge(entity);

    }

    @Override
    public void delete(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
