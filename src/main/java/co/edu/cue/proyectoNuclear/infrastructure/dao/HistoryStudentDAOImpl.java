package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.HistoryStudent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class HistoryStudentDAOImpl implements GeneralDAO<HistoryStudent>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HistoryStudent> getTableList() {
        TypedQuery<HistoryStudent> query = entityManager.createQuery("SELECT h FROM HistoryStudent h", HistoryStudent.class);
        return query.getResultList();
    }

    @Override
    public HistoryStudent findById(Long id) {
        return entityManager.find(HistoryStudent.class, id);
    }

    @Override
    public void save(HistoryStudent entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(HistoryStudent entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        HistoryStudent historyStudent = findById(id);
        if (historyStudent != null) {
            entityManager.remove(historyStudent);
        }
    }
}
