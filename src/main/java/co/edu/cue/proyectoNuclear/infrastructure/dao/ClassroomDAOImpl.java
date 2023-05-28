package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.ClassroomMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ClassroomDAOImpl implements GeneralDAO<ClassroomDto>{

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ClassroomMapper classMap;

    @Override
    public List<ClassroomDto> getTableList(){
        TypedQuery<Classroom> query = entityManager.createQuery("SELECT u FROM Classroom u", Classroom.class);
        return classMap.mapList(query.getResultList());
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
