package co.edu.cue.proyectoNuclear.services.impl;


import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.enums.Campus;
import co.edu.cue.proyectoNuclear.domain.enums.Property;
import co.edu.cue.proyectoNuclear.infrastructure.dao.ClassroomDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.ClassroomMapper;
import co.edu.cue.proyectoNuclear.services.ClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    ClassroomDAOImpl classroomDAO;

    @Autowired
    public static ClassroomDto classroomDto;


    private ClassroomMapper classroomMapper;


    @Override
    public List<ClassroomDto> generateClassroom() {
        List<ClassroomDto> classroomDtos = classroomDAO.getTableList();
        return classroomDtos;
    }



    @Override
    public List<Property> createPropertyListFromString(String propertyListString){
        List<Property> propertyList = new ArrayList<>();
        if (propertyListString != null && !propertyListString.isEmpty()) {
            List<String> propertyValues = Arrays.asList(propertyListString.split(","));
            for (String value : propertyValues) {
                try {
                    int intValue = Integer.parseInt(value);
                    Property property = Property.values()[intValue];
                    propertyList.add(property);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {

                }
            }
        }
        return propertyList;
    }

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

    @Override
    public void createClassroom(String number, Integer capacity, Campus location, String status, List<Property> propertyList, String observation) {
        System.out.println("number: " + number);
        System.out.println("capacity: " + capacity);
        System.out.println("location: " + location);
        System.out.println("status: " + status);
        System.out.println("propertyList: " + propertyList);
        System.out.println("observation: " + observation);

        ClassroomDto classroomDto = new ClassroomDto(null, number, capacity, location, status, new ArrayList<>(), propertyList, observation);
        classroomDAO.save(classroomMapper.mapToEntity(classroomDto));
    }


    @Override
    public void editClassroom(Classroom classroomDto) {
        classroomDAO.update(classroomDto);
    }

    @Override
    public void deleteClassroomById(Long id) {
        classroomDAO.delete(id);
    }
    public ClassroomDto getClassroomDto() {
        return classroomDto;
    }

    @Override
    public ClassroomDto getById(Long id) {
        return classroomDAO.findById(id);
    }


}
