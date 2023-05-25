package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class AdministrativeDAOImpl {

    @PersistenceContext
    EntityManager entityManager;

    private AdministrativeMapper adminMapper;
/*
    @Override
    public List<AdministrativeDto> getTableList() {
        TypedQuery<Administrative> query = entityManager.createQuery("SELECT u FROM Administrative u", Administrative.class);

        return adminMapper.maplist(query.getResultList());
    }

    @Override
    public Administrative findById(Long id) {
        return entityManager.find(Administrative.class, id);
    }


    public void save(AdministrativeDto entity) {
        entityManager.persist(adminMapper.mapToEntity(entity));
    }

    /*@Override
    public void update(AdministrativeDto entity) {
        //find by id
        //tomar la entidad y settear todos los campos que vienen en el dto
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Administrative administrative = entityManager.find(Administrative.class, id);
        if (administrative != null) {
            entityManager.remove(administrative);
        }
    }*/



}
