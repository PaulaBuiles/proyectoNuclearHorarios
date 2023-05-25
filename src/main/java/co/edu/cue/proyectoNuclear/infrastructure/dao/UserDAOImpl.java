package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Transactional
public class UserDAOImpl implements GeneralDAO<User> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getTableList(){
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(User entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        User entity = entityManager.find(User.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
