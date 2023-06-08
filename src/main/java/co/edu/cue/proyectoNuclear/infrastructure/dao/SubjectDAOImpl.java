package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.SubjectMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class SubjectDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    private SubjectMapper subjectMapper;
    private TeacherMapper teacherMapper;
    private TeacherDAOImpl teacherDAO;

    public List<SubjectDto> getTableList() {
        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s", Subject.class);
        List<Subject> subjectList = query.getResultList();
        return subjectMapper.mapList(subjectList);
    }

    public SubjectDto findById(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        return subjectMapper.mapSubject(subject);
    }

    public void save(SubjectDto entity) {
        Subject subject = subjectMapper.mapToEntity(entity);
        entityManager.persist(subject);
    }

    public void update(Subject subject) {
        Subject subjectFind = entityManager.find(Subject.class, subject.getId());
        if (subjectFind == null) {
            throw new EntityNotFoundException("Materia no encontrada");
        }
        entityManager.merge(subjectFind);
    }


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

            }
        }
    }

}
