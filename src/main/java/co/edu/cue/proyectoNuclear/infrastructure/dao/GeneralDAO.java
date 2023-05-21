package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.*;

import java.util.List;

public interface GeneralDAO<T> {
    List<T> getTableList();
}
