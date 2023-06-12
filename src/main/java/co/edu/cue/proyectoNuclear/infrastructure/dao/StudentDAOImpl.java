package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.StudentMapper;
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
public class StudentDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    private final StudentMapper studentMapper ;


    public List<StudentDto> getTableList() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> studentList = query.getResultList();
        return studentMapper.mapList(studentList);
    }

    public StudentDto findById(Long id) {
        Student student = entityManager.find(Student.class, id);
        return studentMapper.mapStudent(student);
    }


    public void save(Student entity) {
        entityManager.persist(entity);
    }


    public void update(Student entity) {
        // Cargar la entidad Student existente
        Student student = entityManager.find(Student.class, entity.getId());
        if (student == null) {
            throw new EntityNotFoundException("Estudiante no encontrado");
        }
        student.setEmail(entity.getEmail());
        student.setName(entity.getName());
        student.getSubject().clear();
        student.setSubject(entity.getSubject());
        entityManager.merge(student);
    }

    public void updatePassword(StudentDto entity) {
        // Cargar la entidad Student existente
        Student student = entityManager.find(Student.class, entity.id());
        if (student == null) {
            throw new EntityNotFoundException("Estudiante no encontrado");
        }
        student.setPassword(entity.password());
        entityManager.merge(student);
    }


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
