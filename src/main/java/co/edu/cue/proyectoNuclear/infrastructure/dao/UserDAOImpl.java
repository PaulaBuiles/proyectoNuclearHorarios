package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements GeneralDAO<User>{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getTableList(){
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public Course save(User entity) {

        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Long id) {

    }
}