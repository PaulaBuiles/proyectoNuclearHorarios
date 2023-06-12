package co.edu.cue.proyectoNuclear.infrastructure.dao;


import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
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

    public Subject findByName(String name) {
        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s WHERE s.name = :name", Subject.class);
        query.setParameter("name", name);
        List<Subject> subjectList = query.getResultList();
        if (subjectList.isEmpty()) {
            return null;
        }
        return subjectList.get(0);
    }

    public List<SubjectDto> getTableList() {
        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s", Subject.class);
        List<Subject> subjectList = query.getResultList();
        return subjectMapper.mapList(subjectList);
    }

    public SubjectDto findById(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        return subjectMapper.mapSubject(subject);
    }

    public void save(Subject entity) {

        entityManager.persist(entity);
    }

    public void update(Subject subject) {
        Subject subjectFind = entityManager.find(Subject.class, subject.getId());
        if (subjectFind == null) {
            throw new EntityNotFoundException("Materia no encontrada");
        }
        subjectFind.getStudents().clear();
        subjectFind.setTeacher(subject.getTeacher());
        subjectFind.setCredit(subject.getCredit());
        subjectFind.setClassroom(subject.getClassroom());
        subjectFind.setStudents(subject.getStudents());
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

    private List<Student> students;

    // Otros métodos de la materia...

    public void deleteStudent(Student student) {
        if (students != null) {
            students.remove(student);
        }
    }

}
