package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.SubjectMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
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
public class SubjectDAOImpl implements GeneralDAO<SubjectDto>{

    @PersistenceContext
    private EntityManager entityManager;

    private SubjectMapper subjectMapper;
    private TeacherMapper teacherMapper;
    private TeacherDAOImpl teacherDAO;

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
            entityManager.merge(subjectMapper.mapToEntity(entity));

    }

    @Override
    public void delete(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        if (subject != null) {
            entityManager.remove(subject);
        }
    }

    public void deleteTeacher(Long id) {
        List<SubjectDto> subjectDtoList = getTableList();
        for (SubjectDto subject : subjectDtoList) {
            if (subject.teacher().getId().equals(id)){
                Subject subject1 = subjectMapper.mapToEntity(subject);
                subject1.setTeacher(teacherMapper.mapToEntity(teacherDAO.findById(0L)));
                update(subjectMapper.mapSubject(subject1));
            }
        }
    }

}
