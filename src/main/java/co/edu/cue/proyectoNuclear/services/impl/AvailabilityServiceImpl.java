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



    public void newAvailability(int day, LocalTime start, LocalTime end, TeacherDto teacherDto){
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        DayOfWeek[] daysOfWeek = DayOfWeek.values();

        if (day < 0 || day >= daysOfWeek.length) {
            throw new IllegalArgumentException("Valor de día inválido: " + day);
        }

        DayOfWeek dayOfWeek = daysOfWeek[day];
        Availability availability = new Availability(null, dayOfWeek, start, end, teacher);
        availabilityDAO.save(availability);

    }

    @Override
    public void deleteAvailabilityById(Long id) {
        availabilityDAO.delete(id);
    }

    @Override
    public void findAvailabilityById(Long id) {
        availabilityDAO.findById(id);
    }
    @Override
    public void editAvailability(int day, LocalTime start, LocalTime end, TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        //Availability availability = null;

        DayOfWeek[] daysOfWeek = DayOfWeek.values();
        DayOfWeek dayOfWeek = daysOfWeek[day];

        /*availability.setId(null);
        availability.setDayOfWeek(dayOfWeek);
        availability.setStart(start);
        availability.setEnd(end);
        availability.setTeacher(teacher);*/
        Availability availability = new Availability(null, dayOfWeek, start, end, teacher);
        availabilityDAO.update(availability);

    }


}
