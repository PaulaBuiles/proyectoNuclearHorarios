package co.edu.cue.proyectoNuclear.services;


import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;

import java.util.List;

public interface AdministrativeService {
    void newReservation(String classroom, String day, String start, String end,int duration);
    public void getScheduleParameters(Long subjectId, int day, Integer durability, String start, String end);
    void createAdministrative(String identification, String name, String email, String password, String role, String charge);
    List<AdministrativeDto> generateAdmin();
    AdministrativeDto findUserAdmin(UserDto user);
}
