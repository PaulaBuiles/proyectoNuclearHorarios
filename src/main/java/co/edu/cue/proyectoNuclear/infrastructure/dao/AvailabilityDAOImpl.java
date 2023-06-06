package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.mapping.dtos.AvailabilityDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AvailabilityMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class AvailabilityDAOImpl implements GeneralDAO<AvailabilityDto> {

    @PersistenceContext
    private EntityManager entityManager;

    private AvailabilityMapper mapper;

    @Override
    public List<AvailabilityDto> getTableList() {
        String query = "SELECT a FROM Availability a";
        return mapper.mapList(entityManager.createQuery(query, Availability.class).getResultList());
    }

    @Override
    public AvailabilityDto findById(Long id) {
        return mapper.mapAvailability(entityManager.find(Availability.class, id));
    }

    @Override
    public void save(AvailabilityDto entity) {
        entityManager.persist(mapper.mapToEntity(entity));
    }

    @Override
    public void update(AvailabilityDto entity) {
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
