package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Schedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ScheduleDAOImpl implements GeneralDAO<ScheduleDto> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Schedule> getTableList(){
        String query = "FROM Schedule";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Schedule findById(Long id) {
        return entityManager.find(Schedule.class, id);
    }

    @Override
    public void save(Schedule entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Schedule entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Schedule entity = entityManager.find(Schedule.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
