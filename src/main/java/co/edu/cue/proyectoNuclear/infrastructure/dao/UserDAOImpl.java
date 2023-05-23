package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

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
        String query = "FROM User";
        String data = entityManager.createQuery(query).getResultList().toString();
        return entityManager.createQuery(query).getResultList();
    }

    public void tryTableList(){
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        System.out.println(query.getResultList().toString());
    }

    //@Override
    public User findById(String id) {
        return null;
    }

    //@Override
    public Course save(User entity) {

        return null;
    }

    //@Override
    public void update(User entity) {

    }

    //@Override
    public void delete(Long id) {

    }
}
