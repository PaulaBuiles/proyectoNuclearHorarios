package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class AvailabilityDAOImpl implements GeneralDAO<Availability> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Availability> getTableList() {
        String query = "SELECT a FROM Availability a";
        return entityManager.createQuery(query, Availability.class).getResultList();
    }

    @Override
    public Availability findById(Long id) {
        return entityManager.find(Availability.class, id);
    }

    @Override
    public void save(Availability entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Availability entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Availability availability = entityManager.find(Availability.class, id);
        if (availability != null) {
            entityManager.remove(availability);
        }
    }
}
