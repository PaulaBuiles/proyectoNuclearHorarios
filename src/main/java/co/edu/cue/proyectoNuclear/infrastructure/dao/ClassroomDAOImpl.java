package co.edu.cue.proyectoNuclear.infrastructure.dao;


import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.ClassroomMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class ClassroomDAOImpl {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ClassroomMapper classMap;

    public List<ClassroomDto> getTableList(){
        TypedQuery<Classroom> query = entityManager.createQuery("SELECT u FROM Classroom u", Classroom.class);
        return classMap.mapList(query.getResultList());
    }

    public ClassroomDto findById(Long id) {
        return classMap.mapClassroom(entityManager.find(Classroom.class, id));
    }


    public void save(Classroom entity) {
        entityManager.persist(entity);
    }

    public void update(Classroom entity) {
        entityManager.merge(entity);
    }

    public void delete(Long id) {
        Classroom classroom = entityManager.find(Classroom.class, id);
        if (classroom != null) {
            entityManager.remove(classroom);
        }
    }
}
