package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.infrastructure.dao.ClassroomDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.ScheduleDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.ScheduleDto;
import co.edu.cue.proyectoNuclear.services.ScheduleService;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    public ScheduleDAOImpl scheduleDAO;


    @Override
    public void asingSubject(Long id, DayOfWeek dayOfWeek, Time durability, LocalTime start, LocalTime end, Subject subject) {
        //Crear horario
        boolean band = true;
        List<ScheduleDto> sc = scheduleDAO.getTableList();
       for(ScheduleDto scheduleDto : sc){
           if(dayOfWeek.equals(scheduleDto.dayOfWeek())){
               if(subject.getClassroom().getName().equals(scheduleDto.subject().getClassroom().getName())){
                   System.out.println(2);
                   if ((start.isAfter(scheduleDto.start()) || start.equals(scheduleDto.start()))
                           && (start.isBefore(scheduleDto.end()))
                           || (end.isAfter(scheduleDto.start()))
                           && (end.isBefore(scheduleDto.end()) || end.equals(scheduleDto.end()))){
                       band = false;
                       System.out.println("Materia crusada");
                   break;
                   }
               }
           }
           if (band){
               System.out.println("Materia creada");
               System.out.println(subject.getName());
           }
           }
       }


    }


