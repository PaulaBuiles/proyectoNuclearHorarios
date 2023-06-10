package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.mapping.dtos.AvailabilityDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AvailabilityMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class AvailabilityDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;


    private AvailabilityMapper availabilityMapper;

    public List<AvailabilityDto> getTableList() {
        String query = "SELECT a FROM Availability a";
        return availabilityMapper.mapList(entityManager.createQuery(query, Availability.class).getResultList());
    }

    public AvailabilityDto findById(Long id) {
        return availabilityMapper.mapAvailability(entityManager.find(Availability.class, id));
    }


    public void save(Availability entity) {
        entityManager.persist(entity);
    }


    public void update(Availability entity) {
        Availability availability = entityManager.find(Availability.class, entity.getId());
        if (availability == null) {
            throw new EntityNotFoundException("Disponibilidad no encontrada");
        }
        availability.setId(null);
        availability.setDayOfWeek(entity.getDayOfWeek());
        availability.setStart(entity.getStart());
        availability.setEnd(entity.getEnd());
        availability.setTeacher(entity.getTeacher());

        entityManager.merge(availability);
    }

    public void delete(Long id) {
        Availability availability = entityManager.find(Availability.class, id);
        if (availability != null) {
            entityManager.remove(availability);
        }
    }


}
