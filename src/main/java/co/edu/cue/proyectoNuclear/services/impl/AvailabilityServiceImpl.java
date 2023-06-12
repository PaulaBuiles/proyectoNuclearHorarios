package co.edu.cue.proyectoNuclear.services.impl;

import java.time.LocalTime;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import co.edu.cue.proyectoNuclear.infrastructure.dao.AvailabilityDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AvailabilityMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import co.edu.cue.proyectoNuclear.services.AvailabilityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Anotación de Spring para marcar esta clase como un componente de servicio
@AllArgsConstructor // Anotación de Lombok para generar automáticamente un constructor que acepta todos los campos
public class AvailabilityServiceImpl implements AvailabilityService {

    // Inyección de dependencias de AvailabilityDAOImpl, AvailabilityMapper y TeacherMapper
    private AvailabilityDAOImpl availabilityDAO;
    private AvailabilityMapper availabilityMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    // Método para crear una nueva disponibilidad
    public void newAvailability(int day, LocalTime start, LocalTime end, TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        DayOfWeek[] daysOfWeek = DayOfWeek.values();

        if (day < 0 || day >= daysOfWeek.length) {
            throw new IllegalArgumentException("Valor de día inválido: " + day);
        }

        DayOfWeek dayOfWeek = daysOfWeek[day];
        Availability availability = new Availability(null, dayOfWeek, start, end, teacher);
        // Guardar la nueva disponibilidad en la base de datos mediante availabilityDAO.save()
        availabilityDAO.save(availability);
    }

    // Método para eliminar una disponibilidad por su identificador
    @Override
    public void deleteAvailabilityById(Long id) {
        // Eliminar la disponibilidad de la base de datos mediante availabilityDAO.delete()
        availabilityDAO.delete(id);
    }

    // Método para encontrar una disponibilidad por su identificador
    @Override
    public void findAvailabilityById(Long id) {
        // Buscar la disponibilidad en la base de datos mediante availabilityDAO.findById()
        availabilityDAO.findById(id);
    }

    // Método para editar una disponibilidad
    @Override
    public void editAvailability(int day, LocalTime start, LocalTime end, TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        DayOfWeek[] daysOfWeek = DayOfWeek.values();
        DayOfWeek dayOfWeek = daysOfWeek[day];

        Availability availability = new Availability(null, dayOfWeek, start, end, teacher);
        // Actualizar la disponibilidad en la base de datos mediante availabilityDAO.update()
        availabilityDAO.update(availability);
    }
}