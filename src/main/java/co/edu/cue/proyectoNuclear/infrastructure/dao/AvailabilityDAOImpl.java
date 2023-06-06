package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
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


    private AvailabilityMapper availabilityMapper;

    @Override
    public List<AvailabilityDto> getTableList() {
        String query = "SELECT a FROM Availability a";
        return availabilityMapper.mapList(entityManager.createQuery(query, Availability.class).getResultList());
    }

    @Override
    public AvailabilityDto findById(Long id) {
        return availabilityMapper.mapAvailability(entityManager.find(Availability.class, id));
    }

    @Override
    public void save(AvailabilityDto entity) {
        Availability availability = availabilityMapper.mapToEntity(entity);
        entityManager.persist(availability);
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
