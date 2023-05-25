package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Element;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ElementDAOImpl implements GeneralDAO<Element> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Element> getTableList() {
        String query = "SELECT e FROM Element e";
        return entityManager.createQuery(query, Element.class).getResultList();
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
