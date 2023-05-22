package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;

import java.util.List;

public interface GeneralDAO<T> {
    List<T> getTableList();
    T findById(String id);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
}
