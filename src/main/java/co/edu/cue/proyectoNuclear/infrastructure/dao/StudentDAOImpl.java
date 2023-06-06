package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.StudentMapper;
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
public class StudentDAOImpl implements GeneralDAO<StudentDto>{

    @PersistenceContext
    private EntityManager entityManager;

    private final StudentMapper studentMapper ;

    @Override
    public List<StudentDto> getTableList() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> studentList = query.getResultList();
        return studentMapper.mapList(studentList);
    }

    @Override
    public StudentDto findById(Long id) {
        Student student = entityManager.find(Student.class, id);
        return studentMapper.mapStudent(student);
    }

    @Override
    public void save(StudentDto entity) {
        Student student = studentMapper.mapToEntity(entity);
        entityManager.persist(student);
    }

    @Override
    public void update(StudentDto entity) {
            entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    public void deleteById(Long id) {
        List<StudentDto> students = getTableList();
        for (StudentDto student: students) {
            if (student.id().equals(id)) {
                delete(student.id());
            }
        }
    }

}
