package co.edu.cue.proyectoNuclear.infrastructure.dao;


import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AdministrativeMapper;
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
public class AdministrativeDAOImpl {

    @PersistenceContext
    EntityManager entityManager;


    private AdministrativeMapper adminMapper;


    public List<AdministrativeDto> getTableList() {
        TypedQuery<Administrative> query = entityManager.createQuery("SELECT u FROM Administrative u", Administrative.class);

        return adminMapper.maplist(query.getResultList());
    }


    public AdministrativeDto findById(Long id) {
        return adminMapper.mapAdministrative(entityManager.find(Administrative.class, id));
    }


    public void save(Administrative entity) {
        entityManager.persist(entity);
    }

    public void update(AdministrativeDto entity) {
        //find by id
        //tomar la entidad y settear todos los campos que vienen en el dto
        entityManager.merge(entity);
    }

    public void updatePassword(AdministrativeDto entity) {
        Student student = entityManager.find(Student.class, entity.id());
        if (student == null) {
            throw new EntityNotFoundException("Estudiante no encontrado");
        }
        student.setPassword(entity.password());
        entityManager.merge(student);
    }

    public void delete(Long id) {
        Administrative administrative = entityManager.find(Administrative.class, id);
        if (administrative != null) {
            entityManager.remove(administrative);
        }
    }



}
