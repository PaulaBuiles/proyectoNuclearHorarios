package co.edu.cue.proyectoNuclear.infrastructure.dao;


import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AdministrativeMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
@AllArgsConstructor
public class AdministrativeDAOImpl {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private AdministrativeMapper adminMapper;
/*
    @Override
    public List<AdministrativeDto> getTableList() {
        TypedQuery<Administrative> query = entityManager.createQuery("SELECT u FROM Administrative u", Administrative.class);

        return adminMapper.maplist(query.getResultList());
    }

    @Override
    public AdministrativeDto findById(Long id) {
        return adminMapper.mapAdministrative(entityManager.find(Administrative.class, id));
    }*/


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
