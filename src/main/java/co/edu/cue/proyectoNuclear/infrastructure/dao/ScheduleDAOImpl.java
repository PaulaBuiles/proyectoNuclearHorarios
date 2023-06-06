package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Schedule;
import co.edu.cue.proyectoNuclear.mapping.dtos.ScheduleDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.ScheduleMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class ScheduleDAOImpl implements GeneralDAO<ScheduleDto> {

    @PersistenceContext
    private EntityManager entityManager;
    private ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleDto> getTableList() {
        TypedQuery<Schedule> query = entityManager.createQuery("SELECT s FROM Schedule s", Schedule.class);
        List<Schedule> scheduleList = query.getResultList();
        return scheduleMapper.mapList(scheduleList);
    }

    @Override
    public ScheduleDto findById(Long id) {
        Schedule schedule = entityManager.find(Schedule.class, id);
        return scheduleMapper.mapSchedule(schedule);
    }

    @Override
    public void save(ScheduleDto entity) {
        Schedule schedule = scheduleMapper.mapToEntity(entity);
        entityManager.persist(schedule);
    }

    @Override
    public void update(ScheduleDto entity) {
            entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Schedule schedule = entityManager.find(Schedule.class, id);
        if (schedule != null) {
            entityManager.remove(schedule);
        }
    }


}
