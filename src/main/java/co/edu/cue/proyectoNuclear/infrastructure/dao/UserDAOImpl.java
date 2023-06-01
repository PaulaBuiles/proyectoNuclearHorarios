package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
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
public class UserDAOImpl implements GeneralDAO<UserDto> {

    @PersistenceContext
    private EntityManager entityManager;
    private UserMapper userMapper;

    @Override
    public List<UserDto> getTableList() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> userList = query.getResultList();
        return userMapper.mapList(userList);
    }

    @Override
    public UserDto findById(Long id) {
        User user = entityManager.find(User.class, id);
        return userMapper.mapUser(user);
    }

    @Override
    public void save(UserDto entity) {
        User user = userMapper.mapToEntity(entity);
        entityManager.persist(user);
    }

    @Override
    public void update(UserDto entity) {
            entityManager.merge(entity);

    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

}
