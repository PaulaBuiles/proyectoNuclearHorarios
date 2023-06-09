package co.edu.cue.proyectoNuclear.infrastructure.dao;



import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
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
public class TeacherDAOImpl {

    @PersistenceContext
    EntityManager entityManager;
    private TeacherMapper teacherMap;

    public List<TeacherDto> getTableList(){
        TypedQuery<Teacher> query = entityManager.createQuery("SELECT u FROM Teacher u", Teacher.class);
        return teacherMap.mapList(query.getResultList());
    }

    public TeacherDto findById(Long id) {
        return teacherMap.mapTeacher(entityManager.find(Teacher.class, id));
    }

    public void save(Teacher entity) {
        entityManager.persist(entity);
    }


    public void update(Teacher entity) {
        Teacher teacher = entityManager.find(Teacher.class, entity.getId());
        if (teacher == null) {
            throw new EntityNotFoundException("Profesor no encontrado");
        }
        teacher.setEmail(entity.getEmail());
        teacher.setName(entity.getName());
        teacher.setAvailability(entity.getAvailability());
        entityManager.merge(teacher);
    }

    public void delete(Long id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher != null) {
            entityManager.remove(teacher);
        }
    }



    public void updatePassword(TeacherDto entity) {
        // Cargar la entidad Student existente
        Teacher teacher = entityManager.find(Teacher.class, entity.id());
        if (teacher == null) {
            throw new EntityNotFoundException("Profesor no encontrado");
        }
        teacher.setPassword(entity.password());
        entityManager.merge(teacher);
    }
}
