package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TeacherDAOImpl implements GeneralDAO<TeacherDto> {

    @PersistenceContext
    EntityManager entityManager;
    TeacherMapper teacherMap;

    @Override
    public List<TeacherDto> getTableList(){
        TypedQuery<Teacher> query = entityManager.createQuery("SELECT u FROM Teacher u", Teacher.class);
        return teacherMap.mapList(query.getResultList());
    }

    @Override
    public TeacherDto findById(Long id) {
        return teacherMap.mapTeacher(entityManager.find(Teacher.class, id));
    }

    @Override
    public void save(TeacherDto entity) {
        entityManager.persist(teacherMap.mapToEntity(entity));
    }

    @Override
    public void update(TeacherDto entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher != null) {
            entityManager.remove(teacher);
        }
    }
}
