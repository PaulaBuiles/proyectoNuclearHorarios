package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.HistoryTeacher;

import co.edu.cue.proyectoNuclear.mapping.dtos.HistoryTeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.HistoryTeacherMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class HistoryTeacherDAOImpl implements GeneralDAO<HistoryTeacherDto>{
    @PersistenceContext
    private EntityManager entityManager;

    private HistoryTeacherMapper historyTeacherMapper;

    @Override
    public List<HistoryTeacherDto> getTableList() {
        TypedQuery<HistoryTeacher> query = entityManager.createQuery("SELECT ht FROM HistoryTeacher ht", HistoryTeacher.class);
        List<HistoryTeacher> historyTeacherList = query.getResultList();
        return historyTeacherMapper.mapList(historyTeacherList);
    }

    @Override
    public HistoryTeacherDto findById(Long id) {
        HistoryTeacher historyTeacher = entityManager.find(HistoryTeacher.class, id);
        return historyTeacherMapper.mapHistoryTeacher(historyTeacher);
    }

    @Override
    public void save(HistoryTeacherDto entity) {
        HistoryTeacher historyTeacher = historyTeacherMapper.mapToEntity(entity);
        entityManager.persist(historyTeacher);
    }

    @Override
    public void update(HistoryTeacherDto entity) {
            entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        HistoryTeacher historyTeacher = entityManager.find(HistoryTeacher.class, id);
        if (historyTeacher != null) {
            entityManager.remove(historyTeacher);
        }
    }
}
