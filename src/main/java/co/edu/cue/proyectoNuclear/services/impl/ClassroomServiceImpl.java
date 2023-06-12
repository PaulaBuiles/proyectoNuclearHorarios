package co.edu.cue.proyectoNuclear.services.impl;



import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.enums.Campus;
import co.edu.cue.proyectoNuclear.domain.enums.Property;
import co.edu.cue.proyectoNuclear.infrastructure.dao.ClassroomDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.ClassroomMapper;
import co.edu.cue.proyectoNuclear.services.ClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service // Anotación de Spring para marcar esta clase como un componente de servicio
@AllArgsConstructor // Anotación de Lombok para generar automáticamente un constructor que acepta todos los campos
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired // Inyección de dependencias de ClassroomDAOImpl
    ClassroomDAOImpl classroomDAO;

    @Autowired // Inyección de dependencias de ClassroomDto
    public static ClassroomDto classroomDto;

    @Autowired // Inyección de dependencias de ClassroomMapper
    private ClassroomMapper classroomMapper;

    // Método para generar la lista de salones
    @Override
    public List<ClassroomDto> generateClassroom() {
        return classroomDAO.getTableList();
    }

    // Método para crear una lista de propiedades a partir de una cadena de texto
    @Override
    public List<Property> createPropertyListFromString(String propertyListString) {
        List<Property> propertyList = new ArrayList<>();
        if (propertyListString != null && !propertyListString.isEmpty()) {
            List<String> propertyValues = Arrays.asList(propertyListString.split(","));
            for (String value : propertyValues) {
                try {
                    int intValue = Integer.parseInt(value);
                    Property property = Property.values()[intValue];
                    propertyList.add(property);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    // Ignorar valores no numéricos o fuera de rango
                }
            }
        }
        return propertyList;
    }

    // Método para determinar la ubicación del salón a partir de un valor de ubicación
    @Override
    public Campus determineLocation(String locationValue) {
        if (locationValue != null) {
            switch (locationValue) {
                case "Nogal":
                    return Campus.NOGAL;
                case "Campina":
                    return Campus.CAMPINA;
                case "Principal":
                    return Campus.PRINCIPAL;
                case "Alcazar":
                    return Campus.ALCAZAR;
            }
        }
        return null;
    }

    // Método para crear un nuevo salón
    @Override
    public void createClassroom(String number, Integer capacity, Campus location, String status, List<Property> propertyList, String observation) {
        System.out.println("number: " + number);
        System.out.println("capacity: " + capacity);
        System.out.println("location: " + location);
        System.out.println("status: " + status);
        System.out.println("propertyList: " + propertyList);
        System.out.println("observation: " + observation);

        ClassroomDto classroomDto = new ClassroomDto(null, number, capacity, location, status, new ArrayList<>(), propertyList, observation);
        // Guardar el nuevo salón en la base de datos mediante classroomDAO.save()
        classroomDAO.save(classroomMapper.mapToEntity(classroomDto));
    }

    // Método para editar un salón
    @Override
    public void editClassroom(Classroom classroomDto) {
        // Actualizar el salón en la base de datos mediante classroomDAO.update()
        classroomDAO.update(classroomDto);
    }

    // Método para eliminar un salón por su identificador
    @Override
    public void deleteClassroomById(Long id) {
        // Eliminar el salón de la base de datos mediante classroomDAO.delete()
        classroomDAO.delete(id);
    }

    // Método para obtener un ClassroomDto por su identificador
    public ClassroomDto getClassroomDto() {
        return classroomDto;
    }

    // Método para obtener un ClassroomDto por su identificador
    @Override
    public ClassroomDto getById(Long id) {
        return classroomDAO.findById(id);
    }
}
