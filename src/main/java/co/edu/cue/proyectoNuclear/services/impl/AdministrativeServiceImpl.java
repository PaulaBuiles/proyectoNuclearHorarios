package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AdministrativeMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdministrativeServiceImpl implements AdministrativeService {

    @Autowired
    public AdministrativeDAOImpl administrativeDAO;


    public AdministrativeMapper administrativeMapper;
    @Autowired
    public UserDAOImpl userGeneralDAO;
    @Autowired
    private final UserMapper userMapper;

    @Override
    public void newReservation(String classroom, String day, String startRequest, String endRequest,int durationRequest){
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        Time duration = new Time(durationRequest,0,0);
        subjectService.addSubject("Reserva",null,0,Long.parseLong(classroom));
    }


    @Override
    public void createAdministrative(String identification,String name,String email,String password,String role,String charge){
        Long id = Long.parseLong(identification);
        UserDto administrativeDto = new UserDto(id, name, email, password, role, true);
        userGeneralDAO.save(userMapper.mapToEntity(administrativeDto));
    }



    //Funciones de los horarios

    //Funciones de los cursos



    //Funciones de los elementos

    //Funciones de la disponibilidad

    //Funciones de las caracteristicas


}
