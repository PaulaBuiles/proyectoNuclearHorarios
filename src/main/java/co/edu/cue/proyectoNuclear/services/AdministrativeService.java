package co.edu.cue.proyectoNuclear.services;


import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;

import java.util.List;

public interface AdministrativeService {
    void newReservation(String classroom, String day, String start, String end,int duration);

    void createAdministrative(String identification, String name, String email, String password, String role, String charge);
    List<AdministrativeDto> generateAdmin();
    AdministrativeDto findUserAdmin(UserDto user);
}
