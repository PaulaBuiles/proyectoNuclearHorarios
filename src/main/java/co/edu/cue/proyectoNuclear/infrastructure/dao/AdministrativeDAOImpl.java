package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class AdministrativeDAOImpl implements GeneralDAO<Administrative> {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Administrative> getTableList() {
        TypedQuery<Administrative> query = entityManager.createQuery("SELECT u FROM Administrative u", Administrative.class);
        return query.getResultList();
    }

    @Override
    public Administrative findById(Long id) {
        return entityManager.find(Administrative.class, id);
    }

    @Override
    public void save(Administrative entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Administrative entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Administrative administrative = entityManager.find(Administrative.class, id);
        if (administrative != null) {
            entityManager.remove(administrative);
        }
    }
}
