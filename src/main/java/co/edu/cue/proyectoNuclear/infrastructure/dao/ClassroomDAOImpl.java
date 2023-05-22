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
    public Classroom findById(String id) {
        return null;
    }

    @Override
    public void save(Classroom entity) {

    }

    @Override
    public void update(Classroom entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
