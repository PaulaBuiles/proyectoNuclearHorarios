package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AdministrativeMapper;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdministrativeServiceImpl implements AdministrativeService {

    @Autowired
    public AdministrativeDAOImpl administrativeDAO;

    @Autowired
    public AdministrativeMapper administrativeMapper;
    @Autowired
    public UserDAOImpl userGeneralDAO;


    @Override
    public void createAdministrative(String identification,String name,String email,String password,String role,String charge){
        Long id = Long.parseLong(identification);
        AdministrativeDto administrativeDto = new AdministrativeDto(id,name,email,password,role,true,charge);
        administrativeDAO.save(administrativeMapper.mapToEntity(administrativeDto));
    }



    //Funciones de los horarios

    //Funciones de los cursos



    //Funciones de los elementos

    //Funciones de la disponibilidad

    //Funciones de las caracteristicas


}
