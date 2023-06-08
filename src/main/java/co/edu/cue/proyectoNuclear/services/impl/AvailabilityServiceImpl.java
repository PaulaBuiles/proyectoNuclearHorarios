package co.edu.cue.proyectoNuclear.services.impl;
import java.sql.Time;
import java.time.LocalTime;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import co.edu.cue.proyectoNuclear.infrastructure.dao.AvailabilityDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.AvailabilityDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AvailabilityMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import co.edu.cue.proyectoNuclear.services.AvailabilityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AvailabilityServiceImpl implements AvailabilityService {


    private AvailabilityDAOImpl availabilityDAO;

    private AvailabilityMapper availabilityMapper;

    private TeacherMapper teacherMapper;



    public void newAvailability(DayOfWeek day, LocalTime start, LocalTime end, TeacherDto teacherDto){
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        Availability availability = new Availability(null,day,start,end,teacher);
        availabilityDAO.save(availabilityMapper.mapAvailability(availability));
    }





}
