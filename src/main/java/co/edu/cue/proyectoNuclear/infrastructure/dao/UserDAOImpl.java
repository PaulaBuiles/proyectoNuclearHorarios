package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class UserDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;


    private UserMapper userMapper;


    public List<UserDto> getTableList() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> userList = query.getResultList();
        return userMapper.mapList(userList);
    }


    public UserDto findById(Long id) {
        User user = entityManager.find(User.class, id);
        return userMapper.mapUser(user);
    }


    public void save(User entity) {
        entityManager.persist(entity);
    }


    public void update(UserDto entity) {
        User user = userMapper.mapToEntity(entity);

            entityManager.merge(user);

    }


    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public User findUserByUsername(String name) {
        String queryString = "SELECT u FROM User u WHERE u.name = :name";
        TypedQuery<User> query = entityManager.createQuery(queryString, User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

}
