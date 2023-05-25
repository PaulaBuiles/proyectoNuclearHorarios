package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
@Transactional
public class StudentDAOImpl implements GeneralDAO<Student>{

    @PersistenceContext
    private EntityManager entityManager;


    private StudentMapper studentMapper;

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

}
