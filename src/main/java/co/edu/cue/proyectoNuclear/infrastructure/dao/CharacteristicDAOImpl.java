package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Characteristic;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CharacteristicDAOImpl implements GeneralDAO<Characteristic> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Characteristic> getTableList() {
        return entityManager.createQuery("SELECT c FROM Characteristic c", Characteristic.class)
                .getResultList();
    }

    @Override
    public Characteristic findById(Long id) {
        return entityManager.find(Characteristic.class, id);
    }

    @Override
    public void save(Characteristic entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Characteristic entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Characteristic entity = entityManager.find(Characteristic.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
