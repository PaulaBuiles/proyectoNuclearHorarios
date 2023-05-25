package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.SubjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SubjectDAOImpl implements GeneralDAO<SubjectDto>{

    @PersistenceContext
    private EntityManager entityManager;


    private SubjectMapper subjectMapper;

    @Override
    public List<SubjectDto> getTableList() {
        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s", Subject.class);
        List<Subject> subjectList = query.getResultList();
        return subjectMapper.mapList(subjectList);
    }

    @Override
    public SubjectDto findById(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        return subjectMapper.mapSubject(subject);
    }

    @Override
    public void save(SubjectDto entity) {
        Subject subject = subjectMapper.mapToEntity(entity);
        entityManager.persist(subject);
    }

    @Override
    public void update(SubjectDto entity) {
            entityManager.merge(entity);

    }

    @Override
    public void delete(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        if (subject != null) {
            entityManager.remove(subject);
        }
    }

}
