package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.HistoryStudent;
import co.edu.cue.proyectoNuclear.domain.entities.HistoryTeacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class HistoryTeacherDAOImpl implements GeneralDAO<HistoryTeacher>{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HistoryTeacher> getTableList() {
        TypedQuery<HistoryTeacher> query = entityManager.createQuery("SELECT h FROM HistoryTeacher h", HistoryTeacher.class);
        return query.getResultList();
    }

    @Override
    public HistoryTeacher findById(Long id) {
        return entityManager.find(HistoryTeacher.class, id);
    }

    @Override
    public void save(HistoryTeacher entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(HistoryTeacher entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        HistoryTeacher historyTeacher = findById(id);
        if (historyTeacher != null) {
            entityManager.remove(historyTeacher);
        }
    }
}
