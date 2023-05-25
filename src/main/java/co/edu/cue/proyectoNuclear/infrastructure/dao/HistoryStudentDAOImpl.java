package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.HistoryStudent;
import co.edu.cue.proyectoNuclear.mapping.dtos.HistoryStudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.HistoryStudentMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class HistoryStudentDAOImpl implements GeneralDAO<HistoryStudentDto>{

    @PersistenceContext
    private EntityManager entityManager;


    private HistoryStudentMapper historyStudentMapper;

    @Override
    public List<HistoryStudentDto> getTableList() {
        TypedQuery<HistoryStudent> query = entityManager.createQuery("SELECT hs FROM HistoryStudent hs", HistoryStudent.class);
        List<HistoryStudent> historyStudentList = query.getResultList();
        return historyStudentMapper.mapList(historyStudentList);
    }

    @Override
    public HistoryStudentDto findById(Long id) {
        HistoryStudent historyStudent = entityManager.find(HistoryStudent.class, id);
        return historyStudentMapper.mapHistoryStudent(historyStudent);
    }

    @Override
    public void save(HistoryStudentDto entity) {
        HistoryStudent historyStudent = historyStudentMapper.mapToEntity(entity);
        entityManager.persist(historyStudent);
    }

    @Override
    public void update(HistoryStudentDto entity) {
            entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        HistoryStudent historyStudent = entityManager.find(HistoryStudent.class, id);
        if (historyStudent != null) {
            entityManager.remove(historyStudent);
        }
    }
}
