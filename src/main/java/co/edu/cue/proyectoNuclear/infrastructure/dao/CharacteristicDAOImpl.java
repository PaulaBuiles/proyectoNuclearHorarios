package co.edu.cue.proyectoNuclear.infrastructure.dao;

import co.edu.cue.proyectoNuclear.domain.entities.Characteristic;
import co.edu.cue.proyectoNuclear.mapping.dtos.CharacteristicDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.CharacteristicMapper;
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
public class CharacteristicDAOImpl implements GeneralDAO<CharacteristicDto> {
    @PersistenceContext
    private EntityManager entityManager;

    private CharacteristicMapper mapper;

    @Override
    public List<CharacteristicDto> getTableList() {
        TypedQuery<Characteristic> query = entityManager.createQuery("SELECT c FROM Characteristic c", Characteristic.class);
        List<Characteristic> characteristicList = query.getResultList();
        return mapper.mapList(characteristicList);
    }

    @Override
    public CharacteristicDto findById(Long id) {
        Characteristic characteristic = entityManager.find(Characteristic.class, id);
        return mapper.mapCharacteristic(characteristic);
    }

    @Override
    public void save(CharacteristicDto entity) {
        Characteristic characteristic = mapper.mapToEntity(entity);
        entityManager.persist(characteristic);
    }

    @Override
    public void update(CharacteristicDto entity) {
        entityManager.merge(entity);

    }

    @Override
    public void delete(Long id) {
        Characteristic characteristic = entityManager.find(Characteristic.class, id);
        if (characteristic != null) {
            entityManager.remove(characteristic);
        }
    }
}
