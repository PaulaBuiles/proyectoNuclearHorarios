package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ClassroomDAOImpl implements GeneralDAO<Classroom>{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Classroom> getTableList(){
        String query = "FROM Classroom ";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ClassroomDto findById(Long id) {
        return classMap.mapClassroom(entityManager.find(Classroom.class, id));
    }

    @Override
    public void save(ClassroomDto entity) {
        entityManager.persist(classMap.mapToEntity(entity));
    }

    @Override
    public void update(ClassroomDto entity) {
        classMap.mapToEntity(entityManager.merge(entity));
    }

    @Override
    public void delete(Long id) {
        Classroom classroom = entityManager.find(Classroom.class, id);
        if (classroom != null) {
            entityManager.remove(classroom);
        }
    }
}
