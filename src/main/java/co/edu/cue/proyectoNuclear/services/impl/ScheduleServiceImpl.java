package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Schedule;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.infrastructure.dao.ScheduleDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.ScheduleDto;
import co.edu.cue.proyectoNuclear.services.ScheduleService;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;


@Service // Anotación de Spring para marcar esta clase como un componente de servicio
@AllArgsConstructor // Anotación de Lombok para generar automáticamente un constructor que acepta todos los campos
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired // Inyección de dependencias de ScheduleDAOImpl
    public ScheduleDAOImpl scheduleDAO;

    // Método para asignar una asignatura a un horario
    @Override
    public void asingSubject(Long id, DayOfWeek dayOfWeek, Time durability, LocalTime start, LocalTime end, Subject subject) {
        boolean band = true;
        // Obtener la lista de horarios existentes
        List<ScheduleDto> sc = scheduleDAO.getTableList();
        for (ScheduleDto scheduleDto : sc) {
            // Verificar si el día de la semana coincide
            if (dayOfWeek.equals(scheduleDto.dayOfWeek())) {
                // Verificar si el horario se superpone con otro horario existente
                if ((start.isAfter(scheduleDto.start()) || start.equals(scheduleDto.start()))
                        && (start.isBefore(scheduleDto.end()))
                        || (end.isAfter(scheduleDto.start()))
                        && (end.isBefore(scheduleDto.end()) || end.equals(scheduleDto.end()))) {
                    // Verificar si el salón es el mismo
                    if (subject.getClassroom().getName().equals(scheduleDto.subject().getClassroom().getName())) {
                        band = false;
                        break;
                    }
                    band = false;
                    break;
                }
            }
        }
        // Si no hay superposición de horarios y salones, se asigna la asignatura al horario
        if (band) {
            Schedule schedule = new Schedule(null, dayOfWeek, durability, start, end, subject);
            scheduleDAO.save(schedule);
        }
    }

    // Método para verificar la disponibilidad de un horario
    public Boolean verifyAvailability(DayOfWeek dayOfWeek, LocalTime start, LocalTime end, String classroom) {
        // Obtener la lista de horarios existentes
        List<ScheduleDto> scheduleDtoList = scheduleDAO.getTableList();
        for (ScheduleDto scheduleDto : scheduleDtoList) {
            // Verificar si el día de la semana coincide
            if (dayOfWeek.equals(scheduleDto.dayOfWeek())) {
                // Verificar si el salón coincide
                if (classroom.equals(scheduleDto.subject().getClassroom().getName())) {
                    // Verificar si hay superposición de horarios
                    if ((start.isAfter(scheduleDto.start()) || start.equals(scheduleDto.start()))
                            && (start.isBefore(scheduleDto.end()))
                            || (end.isAfter(scheduleDto.start()))
                            && (end.isBefore(scheduleDto.end()) || end.equals(scheduleDto.end()))) {
                        return false; // Hay superposición de horarios, no está disponible
                    }
                }
            }
        }
        return true; // No hay superposición de horarios, está disponible
    }
}


