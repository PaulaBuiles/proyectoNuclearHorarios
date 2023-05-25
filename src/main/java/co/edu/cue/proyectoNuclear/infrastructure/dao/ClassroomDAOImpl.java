package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ClassroomDAOImpl implements GeneralDAO<Classroom>{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Classroom> getTableList(){
        String query = "FROM Classroom ";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Classroom findById(Long id) {
        return entityManager.find(Classroom.class, id);
    }

    @Override
    public void save(Classroom entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Classroom entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Classroom classroom = entityManager.find(Classroom.class, id);
        if (classroom != null) {
            entityManager.remove(classroom);
        }
    }
}
