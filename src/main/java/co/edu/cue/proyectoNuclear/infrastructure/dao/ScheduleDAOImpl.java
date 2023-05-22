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
public class ScheduleDAOImpl implements GeneralDAO<Schedule> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Schedule> getTableList(){
        String query = "FROM Schedule";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Schedule findById(String id) {
        return null;
    }

    @Override
    public void save(Schedule entity) {

    }

    @Override
    public void update(Schedule entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
