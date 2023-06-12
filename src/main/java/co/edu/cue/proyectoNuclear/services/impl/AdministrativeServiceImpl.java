package co.edu.cue.proyectoNuclear.services.impl;


import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AdministrativeMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.SubjectMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;

import java.util.List;

@AllArgsConstructor // Anotación de Lombok para generar automáticamente un constructor que acepta todos los campos
@Service // Anotación de Spring para marcar esta clase como un componente de servicio
public class AdministrativeServiceImpl implements AdministrativeService {

    // Inyección de dependencias de AdministrativeDAOImpl, AdministrativeMapper, SubjectMapper y UserDAOImpl
    @Autowired
    public AdministrativeDAOImpl administrativeDAO;
    @Autowired
    public AdministrativeMapper administrativeMapper;
    @Autowired
    public SubjectMapper subjectMapper;
    @Autowired
    public UserDAOImpl userGeneralDAO;

    @Autowired
    public SubjectDAOImpl subjectDAO;

    // Declaración de objetos de otros servicios relacionados
    public AvailabilityServiceImpl availabilityService;
    public ClassroomServiceImpl classroomService;
    public SubjectServiceImpl subjectService;
    public ScheduleServiceImpl scheduleService;

    @Autowired
    private final UserMapper userMapper;

    // Método para crear una nueva reserva
    @Override
    public void newReservation(String classroom, String day, String startRequest, String endRequest, int durationRequest) {
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        Time duration = new Time(durationRequest, 0, 0);
        // Agregar una nueva asignatura de reserva mediante subjectService.addSubject()
        subjectService.addSubject("Reserva", null, 0, Long.parseLong(classroom));
    }

    // Método para crear un nuevo administrativo
    @Override
    public void createAdministrative(String identification, String name, String email, String password, String role, String charge) {
        Long id = Long.parseLong(identification);
        UserDto administrativeDto = new UserDto(id, name, email, password, role, true);
        // Guardar el nuevo administrativo en la base de datos mediante userGeneralDAO.save()
        userGeneralDAO.save(userMapper.mapToEntity(administrativeDto));
    }

    // Método para generar una lista de administrativos
    @Override
    public List<AdministrativeDto> generateAdmin() {
        // Obtener una lista de AdministrativeDto mediante administrativeDAO.getTableList()
        List<AdministrativeDto> administrativeDtoList = administrativeDAO.getTableList();
        return administrativeDtoList;
    }

    // Método para obtener parámetros de horario
    @Override
    public void getScheduleParameters(Long subjectId, int day, Integer durability, String start, String end) {
        DayOfWeek dayOfWeek = DayOfWeek.getByValue(day);
        Time time = new Time(durability, 00, 00);
        // Asignar una asignatura al horario mediante scheduleService.asingSubject()
        scheduleService.asingSubject(null, dayOfWeek, time, LocalTime.parse(start), LocalTime.parse(end), subjectMapper.mapToEntity(subjectDAO.findById(subjectId)));
    }

    // Método para encontrar un administrativo por usuario
    @Override
    public AdministrativeDto findUserAdmin(UserDto user) {
        List<AdministrativeDto> administrativeDtoList = generateAdmin();
        AdministrativeDto administrativeDto = null;
        for (AdministrativeDto admin : administrativeDtoList) {
            if (admin.id().equals(user.id())) {
                administrativeDto = admin;
            }
        }
        return administrativeDto;
    }
}

