package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Element;
import co.edu.cue.proyectoNuclear.mapping.dtos.ElementDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.ElementMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class ElementDAOImpl implements GeneralDAO<ElementDto> {

    @PersistenceContext
    private EntityManager entityManager;
    private ElementMapper mapper;

    @Override
    public List<ElementDto> getTableList() {
        String query = "SELECT e FROM Element e";
        return mapper.mapList(entityManager.createQuery(query, Element.class).getResultList());
    }

    @Override
    public ElementDto findById(Long id) {
        return mapper.mapElement(entityManager.find(Element.class, id));
    }

    @Override
    public void save(ElementDto entity) {
        entityManager.persist(mapper.mapToEntity(entity));
    }

    @Override
    public void update(ElementDto entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Element element = entityManager.find(Element.class, id);
        if (element != null) {
            entityManager.remove(element);
        }
    }
}
