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

import java.util.ArrayList;
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
        // Cargar la entidad Student existente
        Student student = entityManager.find(Student.class, entity.id());
        if (student == null) {
            throw new EntityNotFoundException("Estudiante no encontrado");
        }
        student.setEmail(entity.email());
        student.setName(entity.name());
        entityManager.merge(student);
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

    //Función de prueba
    /*public void addSubject(){
        Student student = entityManager.find(Student.class, 8351907624L);
        List<Subject> subjects = new ArrayList<>();
        subjects.add(entityManager.find(Subject.class, 1));
        subjects.add(entityManager.find(Subject.class, 2));
        subjects.add(entityManager.find(Subject.class, 3));
        subjects.add(entityManager.find(Subject.class, 4));
        subjects.add(entityManager.find(Subject.class, 5));
        subjects.add(entityManager.find(Subject.class, 6));
        subjects.add(entityManager.find(Subject.class, 7));
        subjects.add(entityManager.find(Subject.class, 8));
        student.setSubject(subjects);
        entityManager.merge(student);
    }*/

}
